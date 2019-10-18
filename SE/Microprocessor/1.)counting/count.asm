	%macro scall 4
	mov rax,%1
	mov rdi,%2
	mov rsi,%3
	mov rdx,%4
	syscall
	%endmacro

;---------------------------------------------------------------------------
section .data

	msg db 10,"Positive Count="
	msgl equ $-msg

	msg2 db 10,"Negative Count="
	msg2l equ $-msg2

	new db "",10
	newl equ $-new
	
	arr dw 43H,05H,23H,-98H,10H;
	section .bss
	pcnt resb 2
	ncnt resb 2
;----------------------------------------------------------------------------
section .text

global _start

_start:

;***********Find out positive and Negative Numbers From Given Array************

	mov byte[pcnt],0
	mov byte[ncnt],0
	mov rcx,5	
	mov rbx,arr
rev:	
		mov rax,[rbx]
		bt rax,63    ;bit test instruction if MSB bit is 0 then number is positive and if 1 it is negative.
		jnc pcount
		inc byte[ncnt]
		jmp next

pcount:
		inc byte[pcnt]

next:
		inc rbx
		dec rcx
		jnz rev	

;*********Display Positive Count*************

	scall 1,1,msg,msgl
	mov al,byte[pcnt]
	cmp al,09h
	jbe next1
	add al,07h

next1:
		add al,30h
		mov byte[pcnt],al
		scall 1,1,pcnt,2

;********Display Negative Count***************
        
	     scall 1,1,msg2,msg2l
		mov al,byte[ncnt]
		cmp al,09h
		jne next2
		add al,07h

next2:
		add al,30h
		mov byte[ncnt],al
		scall 1,1,ncnt,2

		scall 1,1,new,newl
		
		mov rax,60
		mov rdi, 0
		syscall

;----------------------------------------END----------------------------------




