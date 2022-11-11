function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
      let searchText = document.getElementById('searchField').value;
      document.getElementById('searchField').value = '';
      let tableBody = document.getElementsByClassName('container')[0].children[2];

      for(let row of Array.from(tableBody.rows)) {
         let flag = false;
         for(let cell of Array.from(row.cells)) {
            if(cell.textContent.includes(searchText)) {
               flag = true;
            }
         }

         if(flag && searchText !== '') {
            row.classList.add('select');
         } else {
            row.classList.remove('select');
         }
      }
   }
}