let input = ['Pesho -> 13 -> 6.00', 'Ivan -> 12 -> 5.57', 'Toni -> 13 -> 4.90'];
storingObjects(input)

function storingObjects(arr) {


    function parseStudent(str) {
        str = str.split(' ->');
        let name = str[0];
        let age = str[1];
        let grade = str[2];

        let obj = {name: name, age: age, grade: grade};
        return obj;
    }

    let students = arr.map(parseStudent);
    students.forEach(student =>{
        let studentsStr =`Name: ${student.name}\n` +
            `Age:${student.age}\n`+
            `Grade:${student.grade}`;
        console.log(studentsStr);
    })

}