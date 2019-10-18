%macro scall 4
mov rax,%1
mov rdi,%2
mov rsi,%3
mov rdx,%4
syscall
%endmacro

section .data

	array dd 15.00,5.00,6.99,7.44,8.00
	count dd 05
	hdec dw 100

	msg 	db 10,"  Enter the choice"
		db 10," 1. Calculate mean",10,13
		db " 2. Calculate variance",10,13
		db " 3. Calculate SD",10,13
		db " 4. Exit",10
	msgl equ $-msg

	pt db "."
	ptl equ $-pt

	msg4 db " Mean is :"
	msgl4 equ $-msg4

	msg5 db " variance is :"
	msgl5 equ $-msg5

	msg6 db " SD is :"
	msgl6 equ $-msg6


section .bss

	choice resb 3
	mean   resd 1
	var    resd 1
	sd     resd 1
	buff   resb 10
	temp   resb 2

section .text
	global _start
          
          _start:
           

	cop:	scall 1,1,msg,msgl
		scall 0,0,choice,3
		mov al,byte[choice]
		cmp al,'1'
		je mean1
		
		cmp al,'2'
		je variance
		
		cmp al,'3'
		je SD
		
		cmp al,'4'
		je cexit
		
		mean1:
			scall 1,1,choice,2
			finit
			fldz
			mov rsi,array
			mov rcx,5
		bk:	fadd dword[rsi]
			add rsi,4
			loop bk
			
			fidiv word[count]
			fst   dword[mean]
			scall 1,1,msg4,msgl4
			call display
			jmp cop
			
		variance:
			mov rsi,array
			mov rcx,5
			
			fldz 
			
		bck1:   fldz
			fld  dword[rsi]
			fsub dword[mean]
			fst ST1
			fmul
			fadd
			add rsi,4
			dec rcx
			jnz bck1
			fidiv word[count]
			fst dword[var]
			scall 1,1,msg5,msgl5
			call display
			jmp cop
			
			
		SD:	fldz
			fld dword[var]
			fsqrt
			scall 1,1,msg6,msgl6
			call display
			jmp cop
			
			
		cexit: call exit
			
display:
	
	fimul word[hdec]
	fbstp tword[buff]
	mov rsi,buff+9
	mov rcx,9
bck3:  
	push rcx
	push rsi
	mov bl,[rsi]
	call disp
	pop rsi
	pop rcx
	dec rsi
	loop bck3
	
	push rsi
	scall 1,1,pt,ptl
	pop rsi
	mov bl,[rsi]
	call disp
	ret
	
disp:
	mov rcx,2
	mov rsi,temp
	
bk5:
	rol bl,4
	mov dl,bl
	and dl,0FH
	cmp dl,09H
	jbe nxt
	add dl,07H
nxt:
	add dl,30H
	mov [rsi],dl
	inc rsi
	dec rcx
	jnz bk5
	
	scall 1,1,temp,2
	
	
	ret	
	
exit:
	mov rax,60
	mov rdi,0
	syscall	



			
		
		

