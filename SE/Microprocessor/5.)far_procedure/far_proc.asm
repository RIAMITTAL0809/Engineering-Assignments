extern far_proc
global fh,char,buff,len

%macro scall 4
	mov rax,%1
	mov rdi,%2
	mov rsi,%3
	mov rdx,%4
syscall
%endmacro

section .data
filen db "Enter the filename : "
filen_l equ $-filen

search db 10,"Enter the character to be searched : "
search_l equ $-search

err db 10,"Error "
err_l equ $-err

section .bss
filename resb 50
buff resb 1024
char resb 2
fh resq 1
len resq 1

section .text
global _start
_start:
	scall 1,1,filen,filen_l
	scall 0,0,filename,50
	
	dec rax
	mov byte[filename+rax],0
	
	scall 1,1,search,search_l
	scall 0,0,char,2
	
	scall 2,filename,2,0777o
	cmp rax,-1h
	jle err_p
	mov [fh],rax
	scall 0,[fh],buff,1024
	mov [len],rax
	
	call far_proc
	call exit_p
		
;----------------------- exit ------------------------------
	exit_p :
		mov rax,60
		mov rdi,0
		syscall
		
	err_p : scall 1,1,err,err_l
		call exit_p
