# hello_world.asm
.data
msg:	.asciiz"entrer un entier\n"
.text
main :
li $v0, 4
la $a0,msg
syscall 
li $v0,5
syscall 
li $t0,1
move $t1,$v0

for: bgt $t0,$t1, end
li $v0,1
move $a0,$t0
syscall 
addi $t0,$t0,1
j for

end:
