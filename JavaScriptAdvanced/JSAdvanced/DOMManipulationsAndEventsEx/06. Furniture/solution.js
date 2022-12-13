function solve() {
  let buttons = document.querySelectorAll('button');
  buttons[0].addEventListener('click', generate);
  buttons[1].addEventListener('click', buy);
  let textareas = document.querySelectorAll('textarea');

  function generate() {
    let currentItems = JSON.parse(textareas[0].value);
    let tableBody = document.getElementsByTagName('tbody')[0];

    for(let item of currentItems) {
      let tableRow = document.createElement('tr');
      tableRow.innerHTML = `<td>
                              <img src=${item.img}>
                            </td>
                            <td>
                              <p>${item.name}</p>
                            </td>
                            <td>
                              <p>${item.price}</p>
                            </td>
                            <td>
                              <p>${item.decFactor}</p>
                            </td>
                            <td>
                              <input type="checkbox"/>
                            </td>
                            `;
      tableBody.appendChild(tableRow);
    }
  }

  function buy() {
    let result = '';
    let checked = Array.from(document.querySelectorAll('input[type=checkbox]:checked'));
    let totalPrice = 0;
    let decFactor = 0;

    result += 'Bought furniture: ';
    let wordsBuffer = [];
    for(let check of checked) {
      let item = check.parentElement.parentElement;
      wordsBuffer.push(item.children[1].textContent.trim());
      totalPrice += Number(item.children[2].textContent.trim());
      decFactor += Number(item.children[3].textContent.trim());
    }

    let linesBuffer = [];
    linesBuffer.push(wordsBuffer.join(', '));
    linesBuffer.push(`Total price: ${totalPrice.toFixed(2)}`);
    linesBuffer.push(`Average decoration factor: ${decFactor / checked.length}`);
    result += linesBuffer.join('\n')
    textareas[1].value = result;
  }
}

