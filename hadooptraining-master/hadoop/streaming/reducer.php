#!/usr/bin/php
<?php
// By dongxicheng,
// blog:http://dongxicheng.org/
// reducer.php
error_reporting(E_ALL ^ E_NOTICE); 
$word2count = array();
// ��׼����Ϊ STDIN
while (($line = fgets(STDIN)) !== false) {
    // �Ƴ�����հ�
    $line = trim($line);
    // ÿһ�еĸ�ʽΪ(���� "tab" ����)������($word, $count)
    list($word, $count) = explode(chr(9), $line);
    // ת����ʽstring -> int
    $count = intval($count);
    //����
    $word2count[$word] += $count;
}
// �����д�� STDOUT (standard output)
foreach ($word2count as $word => $count) {
    echo $word, chr(9), $count, PHP_EOL;
}
?> 

