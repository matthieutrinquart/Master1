.data
msg1:	.asciiz"valeur de a\n"
.text

main:
	li $v0, 4
	la $a0,msg1
	syscall 
	li $v0,5
	syscall 
	move $a0,$v0
        jal     fib
        move    $a0, $v0
        li      $v0, 1          # Afficher
        syscall
        li      $v0, 10         # Quitter
        syscall

fib:
        # Sauver l'adresse de retour et le param�tre
        subi    $sp, $sp, 8
        sw      $ra, 4($sp)
        sw      $a0, 0($sp)

        bgt     $a0, 1, recurse
        move    $v0, $a0
        j       return

recurse:
        subi    $a0, $a0, 1
        jal     fib             # fib(n - 1)

        # Sauver le r�sultat de l'appel
        subi    $sp, $sp, 4
        sw      $v0, ($sp)

        subi    $a0, $a0, 1
        jal     fib             # fib(n - 2)

        # R�cup�rer le r�sultat de l'appel
        lw      $t0, ($sp)
        addi    $sp, $sp, 4

        add     $v0, $v0, $t0   # fib(n - 1) + fib(n - 2)

return:
        # R�cup�rer l'adresse de retour et le param�tre
        lw      $a0, 0($sp)
        lw      $ra, 4($sp)
        addi    $sp, $sp, 8

        jr      $ra