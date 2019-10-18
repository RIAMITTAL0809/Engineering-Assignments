extern fh,char,buff,len
global far_proc

%macro scall 4
	mov rax,%1
	mov rdi,%2
	mov rsi,%3
	mov rdx,%4
syscall
%endmacro


section .data
space db 10,"Number of spaces are : "
space_l equ $-space
	
no db 10,"Number of lines are : "
no_l equ $-no
	
cha db 10,"Number of character occurences : "
cha_l equ $-cha
	
nline db 10
nline_l equ $-nline
	
r db 10,"ok",10
rl equ $-r	
	
section .bss
scount resq 1
ncount resq 1
ccount resq 1
temp resq 1
ans resb 2
	
section .txt
global _main
_main:
	far_proc:
		mov rax,0
		mov rbx,0
		mov rcx,0
		mov rdx,0
		mov rdi,0
		mov rsi,0
		
		mov bl,[char]
		mov rsi,buff
		mov rcx,[len]
		
	back :	mov al,[rsi]
		cmp al,20h
		jne line
		inc byte[scount]
		jmp next1
		
	line :  cmp al,0Ah
		jne co
		inc byte[ncount]
		jmp next1
		
	co : 	cmp al,bl
		jne next1
		inc byte[ccount]
	next1 : inc rsi
		dec rcx
		jnz back
		
		scall 1,1,space,space_l
		mov rax,[scount]
		call disp
		;scall 1,1,scount,1
		
		scall 1,1,no,no_l
		mov rax,[ncount]
		call disp
		;scall 1,1,ncount,1
		
		scall 1,1,cha,cha_l
		mov rax,[ccount]
		call disp
		;scall 1,1,ccount,1	
		
		scall 1,1,nline,nline_l
		scall 3,[fh],0,0
	ret	
	
 disp : 
 	mov rcx,2
 	mov rbx,temp
 		
 loop :	;mov al,[rdi]
 	rol al,4
 	mov dl,al
 	and dl,0Fh
 	cmp dl,09h
 	jle nxt
 	add dl,07h
 	
 nxt :  add dl,30h
 	mov [rbx],dl
 	inc rbx
 	;inc rdi
 	dec rcx
 	jnz loop
 	
 	scall 1,1,temp,2
 	
 ret
 	 
