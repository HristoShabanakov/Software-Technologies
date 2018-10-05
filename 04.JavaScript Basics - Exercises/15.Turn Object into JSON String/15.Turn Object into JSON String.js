function turnObjectIntoJSONString (arr) {
    let obj = {};
    obj.name = arr[0].split(" -> ") [1];
    obj.surname = arr[1].split(" -> ") [1];
    obj.age = Number(arr[2].split(" -> ") [1]);
    obj.grade = Number(arr[3].split(" -> ") [1]);
    obj.date = arr[4].split(" -> ") [1];
    obj.town = arr[5].split(" -> ") [1];
    return JSON.stringify(obj);
}