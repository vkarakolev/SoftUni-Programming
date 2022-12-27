function addRemove(arr) {
    let result = [];

    for (let i = 0; i < arr.length; i++) {
        if(arr[i] == 'add') {
            result.push(i + 1);
        } else {
            result.pop();
        }
    }

    if(result.length == 0) {
        console.log('Empty')
    } else {
        console.log(result.join('\n'));
    }
}

addRemove(['add', 'add', 'add', 'add']);
addRemove(['add', 'add', 'remove', 'add', 'add']);
addRemove(['remove', 'remove', 'remove']);