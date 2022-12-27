function timeToWalk(steps, footprintInMeters, kmForHour) {
    let distanceInMeters = steps * footprintInMeters;
    let metersInSec = kmForHour / 3.6;
    let restInMin = Math.floor(distanceInMeters / 500);
    let secondsToWalk = distanceInMeters / metersInSec;
    let totalSeconds = secondsToWalk + restInMin * 60;

    let seconds = Math.round(totalSeconds % 60);
    let minutes = Math.floor(totalSeconds / 60);
    let hours = Math.floor(minutes / 60);

    let formattedH = hours < 10 ? '0' + hours : hours;
    let formattedM = minutes < 10 ? '0' + minutes : minutes;
    let formattedS = seconds < 10 ? '0' + seconds : seconds;

    console.log(`${formattedH}:${formattedM}:${formattedS}`);
}

timeToWalk(4000, 0.60, 5);
timeToWalk(2564, 0.70, 5.5);