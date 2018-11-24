<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>
</head>
<body>
    <form>
        N: <input type="text" name="num" />
        <input type="submit" />
    </form>
    <?php
    if(isset($_GET['num'])){
        $num = intval($_GET['num']);
        $a = 0;
        $b = 1;
        for ($i=0; $i <$num; $i++ ){
            echo $b . " ";
            $temp = $a +$b;
            $a = $b;
            $b = $temp;
        }
    }
    ?>
</body>
</html>