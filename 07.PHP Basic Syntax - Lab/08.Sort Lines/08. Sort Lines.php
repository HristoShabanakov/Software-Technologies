<?php
$sortedLines = "";
if (isset($_GET['lines'])){
//Explode split the input by empty row (\n) and returns an array.
    $lines = explode("\n",$_GET['lines']);
//Array_map is the same as .Select and .Where in C#. Trim removes the whitespaces from the begging and end.
//Array_filter removes the empty spaces in array.
    $lines = array_filter(array_map('trim',$lines));
//Sorting the array as strings.
    sort($lines,SORT_STRING);
//Implode is the same as string.join in C#.
    $sortedLines = implode("\n", $lines);
}
?>
<form>
    <textarea rows="10" name="lines"><?= $sortedLines?></textarea><br>
    <input type="submit" value="Sort">
</form>
