%macro scall 4
	mov rax,%1
	mov rdi,%2
	mov rsi,%3
	mov rdx,%4
	syscall
%endmacro

;-----------------------------------------------------------------------------

section .data
	m1 db "Enter first number :",0xa
	l1 equ $-m1
	m2 db "Enter second number :",0xa
	l2 equ $-m2
	m3 db "The result is :",0xa
	l3 equ $-m3
	new db "",10
	newl equ $-new
	
	m4 db "Enter 1.Successive Addition",0xa
	   db "Enter 2.Add and Shift method",0xa
	   db "Enter choice :",0xa
        l4 equ $-m4	
	
	m5 db "The Multiplication is:-",0xA
	l5 equ $-m5

;------------------------------------------------------------------------------
	
section .bss
    	choice resb 2
	num1 resb 9
	num2 resb 9
	res resb 17
	char_ans resb 17

;------------------------------------------------------------------------------
	
section .text
global _start
_start:
;---------------------------Accepting the values---------------------

		scall 1,1,m1,l1
		scall 0,0,num1,9
		mov rsi,num1                     ;accept 1st number
		call accept_proc
		mov [num1],rbx
		
		scall 1,1,m2,l2
		scall 0,0,num2,9
		mov rsi,num2                      ;accept second number
		call accept_proc
		mov [num2],rbx
	
		
		scall 1,1,m4,l4            ;display the menu
		scall 0,0,choice,2           ;get choice
		
	mov al,byte[choice]            	;choice 1 
    	cmp al,31h
    	je op1
    	
    	mov al,byte[choice]				;choice 2
    	cmp al,32h
    	je op2
		
;--------------------------exit-----------------------------------
exit:
		mov rax,60
		mov rdi,0
		syscall

;----------------- selected choice-------------------------
op1:		call succ
		mov qword[res],rdx
		scall 1,1,m5,l5                   ;call succesive addition
		call display_proc	                ;display result for succesive addition
		scall 1,1,new,newl
		jmp exit
		
op2:
		call shiftadd
		mov qword[res],rdx
		
		call display_proc	                ;display result for shift addition
		scall 1,1,new,newl
		jmp exit
		

;---------------------------successive addition---------------------	
succ:
		mov rax,[num1]
		mov rbx,[num2]
		mov rdx,0
		
back1:
		add rdx,rax
		dec rbx
		jnz back1
		ret
		
		
;-----------------------shift Addition------------------------------

shiftadd:
			mov rax,qword[num1]
			mov rbx,qword[num2]
			mov rcx,64
			mov rdx,0

loo1:
			shl rdx,1
			rol rax,1
			jnc n1			
			add rdx,rbx
n1:			
			dec rcx
			jnz loo1
			ret
		
;----------------------Accepting procedure-------------------------------
accept_proc:
		mov rbx,0
		mov rax,0
		mov rcx,8
	
back:
		rol rbx,04
		mov al,[rsi]
	
		cmp al,39h
		jbe next
	
		sub al,07h
	
next:
		sub al,30h
		add rbx,rax
		
		inc rsi
		
		dec rcx
		jnz back
        	ret

;---------------------------Display Procedure---------------------------
display_proc:
			mov rdx,[res]
			mov rsi, char_ans 
			mov rcx,16
	
up3:
		rol rdx,04
		mov al,dl
		and al,0Fh
		cmp al,09h
		jbe next2
		add al,07h

next2:
		add al,30h
		mov [rsi],al
		inc rsi
		dec rcx
		jnz up3
				
		scall 1,1,char_ans,16
		
		ret
