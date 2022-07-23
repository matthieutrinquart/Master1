# hello_world.asm
.data
msg:	.asciiz"entrer un entier\n"

.text
main : li $v0 , 4
la $a0,msg
syscall
li $v0,5
syscall
bge $v0,$zero,disp
neg $v0,$v0


disp : move $a0,$v0
	li $v0,1
	syscall 

