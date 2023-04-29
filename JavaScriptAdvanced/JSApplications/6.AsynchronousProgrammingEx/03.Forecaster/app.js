function attachEvents() {
    const button = document.getElementById('submit');
    button.addEventListener('click', getWeather);
}

async function getWeather(e) {
    const inputLocation = document.getElementById('location').value;
    const forecastDiv = document.getElementById('forecast');

    forecastDiv.style.display = 'block';
    clearForecastDiv(forecastDiv);

    try {
        const response = await fetch('http://localhost:3030/jsonstore/forecaster/locations');
        const locations = await response.json();

        const currentLocation = locations.find(l => l.name === inputLocation);
        const code = currentLocation.code;

        const todayResponse = await fetch('http://localhost:3030/jsonstore/forecaster/today/' + code);
        const today = await todayResponse.json();

        const threeDayResponse = await fetch('http://localhost:3030/jsonstore/forecaster/upcoming/' + code);
        const threeDay = await threeDayResponse.json();

        attachTodayForecast(today);
        attachThreeDayForecast(threeDay);
    } catch (err) {
        let labels = document.querySelectorAll('.label');
        labels.forEach(l => {
            l.textContent = "Error";
        });
    }
}

function attachTodayForecast(today) {
    const { condition, high, low } = today.forecast;
    const locationName = today.name;

    const forecasts = document.createElement('div');
    forecasts.className = 'forecasts';

    const degrees = getSymbol('Degrees');
    forecasts.innerHTML =
        `<span class="condition symbol">${getSymbol(condition)}</span>
        <span clas="condition">
            <span class="forecast-data">${locationName}</span>
            <span class="forecast-data">${low}${degrees}/${high}${degrees}</span>
            <span class="forecast-data">${condition}</span>
        </span>`;

    document.getElementById('current').appendChild(forecasts);
}

function attachThreeDayForecast(threeDay) {
    const forecastInfo = document.createElement('div');
    forecastInfo.classList.add('forecast-info');

    const locationName = threeDay.name;
    const degrees = getSymbol('Degrees');
    for (let day of threeDay.forecast) {
        const { condition, high, low } = day;

        const upcomingSpan = document.createElement('span');
        upcomingSpan.className = 'upcoming';

        upcomingSpan.innerHTML =
            `<span class="symbol">${getSymbol(condition)}</span>
            <span class="forecast-data">${low}${degrees}/${high}${degrees}</span>
            <span class="forecast-data">${condition}</span>`;

        forecastInfo.appendChild(upcomingSpan);
    }

    document.getElementById('upcoming').appendChild(forecastInfo);
}

function getSymbol(condition) {
    switch (condition) {
        case 'Sunny': return '&#x2600;';
        case 'Partly sunny': return '&#x26C5;';
        case 'Overcast': return '&#x2601;';
        case 'Rain': return '&#x2614;';
        case 'Degrees': return '&#176;';
    }
}

function clearForecastDiv(forecastDiv) {
    forecastDiv.innerHTML =
        `<div id="current">
                <div class="label">Current conditions</div>
            </div>
            <div id="upcoming">
                <div class="label">Three-day forecast</div>
            </div>`;
}

attachEvents();