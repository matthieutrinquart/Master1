# hello_world.asm
.data
msg1:	.asciiz"valeur de a\n"
.text
main :

li $v0, 4
la $a0,msg1
syscall 
li $v0,5
syscall 
move $a0,$v0
jal sum
move $a0,$v0
li $v0, 1
syscall 

li $v0, 10
syscall


sum: 
addi $sp, $sp, -8 # make room
sw $ra, 0($sp) # store $ra
sw $a0, 4($sp) # store $ra
blez $a0,sum0
sub $a0,$a0,1
jal sum
lw $ra, 0($sp) # restore $ra
lw $a0, 4($sp) # restore $ra


add $v0,$a0,$v0

addi $sp, $sp, 8 # restore $sp
jr $ra

sum0: 
move $v0,$zero
jr $ra
