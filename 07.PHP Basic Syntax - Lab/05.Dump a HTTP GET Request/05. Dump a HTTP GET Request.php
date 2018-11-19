<form>
    <div>Name:</div><input type="text" name="personName"/>
    <div>Age:</div><input type="number" name="age"/>
    <div>Town</div>
    <select name="townId">
        <option value="10">Sofia</option>
        <option value="20">Veliko Tarnovo</option>
        <option value="30">Brussels</option>
    </select>
    <div><input type="submit"/></div>
</form>
<?php var_dump($_GET); ?>;

<?php
    if(isset($_GET["age"])){
        $agenum = intval($_GET["age"]) + 1;
        echo "The next year you will be $agenum years old.";
    }
?>