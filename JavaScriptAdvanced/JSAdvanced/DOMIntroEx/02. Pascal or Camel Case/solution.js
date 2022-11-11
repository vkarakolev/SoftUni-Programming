function solve() {
  let input = document.getElementById('text').value ;
  let convention = document.getElementById('naming-convention').value;
  let words = input.split(' ');
  let result = '';

  switch(convention) {
    case 'Camel Case' :
      words.forEach((e, i) => {
        if(i === 0) {
          return result += e.toLowerCase();
        }
        return result += e[0].toUpperCase() + e.substring(1).toLowerCase();
      });
      break;
    case 'Pascal Case' :
      for(let w of words) {
        result += w[0].toUpperCase() + w.substring(1).toLowerCase();
      }
      break;
    default: result = 'Error!';
  }

  document.getElementById('result').textContent += result;
}