function solve() {
  let input = document.getElementById('input').value;
  let output = document.getElementById('output');
  output.innerHTML = '';
  let sentenceArray = input.split('.').filter(e => e.length > 0);

  for(let i  = 0; i < sentenceArray.length; i += 3) {
    let currentParagraph = [];
    for(let k = 0; k < 3; k++) {
      if(sentenceArray[i + k]) {
        currentParagraph.push(sentenceArray[i + k]);
      }
    }    

    let result = currentParagraph.join('. ') + '.';
    output.innerHTML += `<p>${result}</p>`;
  }
}