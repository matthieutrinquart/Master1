# hello_world.asm
.data

array:	.space 16

.text
main :
la $t0, array
li $s0,1
sw $s0,($t0)
li $s0,2
sw $s0,4($t0)
li $s0,3
sw $s0,8($t0)

lw $t1,($t0)
lw $t2, 8($t0)

sw $t2,($t0)
sw $t1, 8($t0)


end: li $v0,10
	syscall 



