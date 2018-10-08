let input = ['3', '0 - 5', '1 - 6', '2 - 7'];
setValues(input);

function setValues(arr) {
    //The splice() method adds/removes items to/from an array, and returns the removed item(s).
    let length = arr.splice(0, 1);
    let result = new Array(Number(length));

    for (let i = 0; i < arr.length; i++) {
        let numbers = arr[i].split(' - ');
        let index = numbers[0];
        let value = numbers[1];

        result[index] = value;
    }
    for (let i = 0; i < result.length; i++) {
        if (result[i] === undefined) {
            console.log(0)
        } else {
            console.log(result[i]);
        }
    }
}

