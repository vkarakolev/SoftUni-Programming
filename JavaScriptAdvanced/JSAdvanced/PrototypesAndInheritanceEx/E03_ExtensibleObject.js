function extensibleObject() {
    return {
        __proto__: {},
        extend: function(template) {
            for(let prop in template) {
                if(typeof(template[prop]) === 'function') {
                    let func = function () {};
                    this.__proto__.func = template[prop];
                    continue;
                }

                this[prop] = prop;
            }
        }
    }
}

const myObj = extensibleObject();
const template = {
    extensionMethod: function () {},
    extensionProperty: 'someString'    
}
    
myObj.extend(template);
console.log(myObj);