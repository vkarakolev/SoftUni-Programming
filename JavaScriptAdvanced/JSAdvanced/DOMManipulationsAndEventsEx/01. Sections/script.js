function create(words) {
   for(let word of words) {
      let p = document.createElement('p');
      p.innerText = word;
      p.style.display = 'none';
      let div = document.createElement('div');
      div.appendChild(p);
      document.getElementById('content').appendChild(div);
      div.addEventListener('click', show);
   }

   function show(e) {
      if(e.target.nodeName === 'p') {
         return;
      }

      let p = e.target.children[0];
      p.style.display = 'block';
   }
}