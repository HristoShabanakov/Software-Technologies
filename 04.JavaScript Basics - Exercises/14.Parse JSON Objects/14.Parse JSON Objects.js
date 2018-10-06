function parseJSONObjects(str) {
    str.forEach(jsonSting => {
        let student = JSON.parse(jsonSting);
        console.log(`Name: ${student.name}`);
        console.log(`Age: ${student.age}`);
        console.log(`Date: ${student.date}`);
    });
}
