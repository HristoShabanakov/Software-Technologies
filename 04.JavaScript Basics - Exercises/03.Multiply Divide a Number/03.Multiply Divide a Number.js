function MultiplyNumberOrDivide(arr) {
    let numberN = Number(arr[0]);
    let numberX = Number(arr[1]);
    if(numberN <= numberX){
        console.log(numberN * numberX);
    }
    else{

        console.log(numberN / numberX);
    }
}
