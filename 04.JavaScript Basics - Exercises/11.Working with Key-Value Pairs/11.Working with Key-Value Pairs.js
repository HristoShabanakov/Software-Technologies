let input = ['3 test', '3 test1', '4 test2', '4 test3', '4 test5', '4'];
keyValuePairs(input);

function keyValuePairs(arr) {
    //Taking the last element. Splice returns an array so we want position [0].
    let resultKey = arr.splice(arr.length - 1, 1) [0];
    //Creating an empty object.
    let dict = {};
    //Foreach the input
    arr.forEach(element =>{
        let tokens =element.split(' ');
        let key = tokens[0];
        let value = tokens[1];
        dict[key]=value;
    });
    //Same like contains in C#
    if(dict.hasOwnProperty(resultKey)){
        console.log(dict[resultKey]);
    }else{
        console.log("None");
    }
}