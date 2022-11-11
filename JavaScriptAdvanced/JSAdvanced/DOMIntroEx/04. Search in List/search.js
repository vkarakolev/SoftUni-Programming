function search() {
   let towns = document.getElementById('towns').children;
   let searchText = document.getElementById('searchText').value;

   let matches = 0;
  for(let t of Array.from(towns)) {
      if(t.textContent.includes(searchText)) {
         t.style.fontWeight = 'bold';
         t.style.textDecoration = 'underline';
         matches++;
      } else {
         t.style.fontWeight = 'normal';
         t.style.textDecoration = 'none';
      }
   };

   let result = ' match found';
   if(matches > 1) {
      result = result.substring(0, 6) + 'es' + result.substring(6);
   }

   document.getElementById('result').textContent = matches + result;
}
