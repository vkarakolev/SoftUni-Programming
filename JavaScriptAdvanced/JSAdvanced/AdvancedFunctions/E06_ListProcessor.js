function solution(input) {
    let strings = [];

    for(let i of input) {
        let command = i.split(' ')[0];
        let str = i.split(' ')[1];
        
        switch(command) {
            case 'add' : strings.push(str); break;
            case 'remove' : strings = strings.filter(e => e != str); break;
            case 'print' : console.log(strings.join(',')); break;
        }
    }
}

solution(['add hello', 'add again', 'remove hello', 'add again', 'print']);
solution(['add pesho', 'add george', 'add peter', 'remove peter','print']);