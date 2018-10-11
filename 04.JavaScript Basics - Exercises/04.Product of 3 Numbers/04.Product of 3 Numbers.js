function productOf3Numbers(arr) {
    let numX = Number(arr[0]);
    let numY = Number(arr[1]);
    let numZ = Number(arr[2]);
    let negativeCount = 0;
    for (let i = 0; i < arr.length; i++) {
        if (Number(arr[i]) < 0) {
            negativeCount++;

        }
    }
    if (arr.some(x => x === 0)) {
        console.log("Positive")
    } else if (negativeCount % 2 === 0) {
        console.log("Positive");
    } else {
        console.log("Negative");
    }
}

let myArray = ['2', '-3', '7'];

productOf3Numbers(myArray);