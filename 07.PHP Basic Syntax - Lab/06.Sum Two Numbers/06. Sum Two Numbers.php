<form>
    <div>First number: <input type="number" name="num1"/></div>
    <div>Second number: <input type="number" name="num2"/></div>
    <input type="submit" value="Calculate"/>
</form>

<?php
if (isset($_GET["num1"]) && isset($_GET["num2"])){
    if(is_int($_GET["num1"]) && is_int($_GET["num2"])){
        $sum = intval($_GET["num1"]) + intval($_GET["num2"]);
        echo "<div>The sum is: $sum</div>";
    }else{
        echo "Error! Please, enter a number!";
    }
}
    ?>