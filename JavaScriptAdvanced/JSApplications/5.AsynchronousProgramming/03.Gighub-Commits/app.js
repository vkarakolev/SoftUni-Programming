async function loadCommits() {
    const username = document.getElementById('username').value;
    const repository = document.getElementById('repo').value;
    
    
    try {
        const response = await fetch(`https://api.github.com/repos/${username}/${repository}/commits`);

        if(response.ok == false) {
            throw new Error(`Error: ${response.status} (Not Found)`)
        }
        
        const data = await response.json();
        
        const ul = document.getElementById('commits');
        
        const commits = data.map(item => {
            const li = document.createElement('li');
            const p = document.createElement('p');
            p.textContent = `${item.commit.author.name}: ${item.commit.message}`;
            li.appendChild(p);
            
            return li;
        });

        ul.replaceChildren(...commits);
    } catch(err) {
        ul.textContent = err.message;   
    }
}