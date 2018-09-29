function solution([input]) {
    //With Number we parse the current input
    let arr = input.split(' ');
    let numberOne = Number(arr[0]);
    let numberTwo = Number(arr[1]);
    let numberThree = Number(arr[2]);

    if (numberOne + numberTwo === numberThree) {
        console.log(`${Math.min(numberOne, numberTwo)} + ${Math.max(numberTwo, numberOne)} = ${numberThree}`);
    }
    else if (numberOne + numberThree === numberTwo) {
        console.log(`${Math.min(numberOne, numberThree)} + ${Math.max(numberOne, numberThree)} = ${numberTwo}`);
    }
    else if (numberTwo + numberThree === numberOne) {
        console.log(`${Math.min(numberTwo, numberThree)} + ${Math.max(numberTwo, numberThree)} = ${numberOne}`);
    }
    else{
        console.log('No');
    }
}
