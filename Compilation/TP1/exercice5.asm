# hello_world.asm
.data
msg1:	.asciiz"valeur de a\n"
msg2:	.asciiz"valeur de b\n"
.text
main :

li $v0, 4
la $a0,msg1
syscall 
li $v0,5
syscall 
move $t1,$v0

li $v0, 4
la $a0,msg2
syscall 
li $v0,5
syscall 

move $a0, $t1
move $a1,$v0
jal sum
move $a0,$v0
li $v0,1
syscall 

li $v0, 10
syscall

sqr:
mul $v0 ,$a0,$a0
jr $ra
sum: 
#addi $sp, $sp, -4# alloue l’espace dans la pile
#sw $t0, 0($sp) # sauve $t0 dans la pile
addi $sp, $sp, -4 # make room
sw $ra, 0($sp) # store $ra

jal sqr
move $t0,$v0
move $a0,$a1
jal sqr
add $v0,$v0,$t0
lw $ra, 0($sp) # restore $ra
addi $sp, $sp, 4 # restore $sp
jr $ra

