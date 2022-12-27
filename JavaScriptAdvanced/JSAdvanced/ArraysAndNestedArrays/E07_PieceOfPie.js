function pieceOfArray(arr, firstPie, secondPie) {
    let startIndex = arr.indexOf(firstPie);
    let endIndex = arr.indexOf(secondPie) + 1;

    console.log(arr.slice(startIndex, endIndex));
}

pieceOfArray(['Pumpkin Pie', 'Key Lime Pie', 'Cherry Pie', 'Lemon Meringue Pie', 'Sugar Cream Pie'], 
'Key Lime Pie', 'Lemon Meringue Pie');
pieceOfArray(['Apple Crisp', 'Mississippi Mud Pie', 'Pot Pie', 'Steak and Cheese Pie', 'Butter Chicken Pie', 'Smoked Fish Pie'], 
'Pot Pie', 'Smoked Fish Pie');