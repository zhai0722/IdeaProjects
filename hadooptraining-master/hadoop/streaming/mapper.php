#!/usr/bin/php
<?php
// By dongxicheng,
// blog:http://dongxicheng.org/
// mapper.php
error_reporting(E_ALL ^ E_NOTICE); 
$word2count = array();
// ��׼����ΪSTDIN (standard input)
while (($line = fgets(STDIN)) !== false) {
   // �Ƴ��հ�
   $line = trim($line);
   // ���в������ɸ�����
   $words = preg_split('/\W/', $line, 0, PREG_SPLIT_NO_EMPTY);
   // �����д�� STDOUT (standard output)
   foreach ($words as $word) {
     // ӡ�� [�� , "tab�ַ�" ,  "����" , "������"]
     echo $word, chr(9), "1", PHP_EOL;
   }
}
?>
