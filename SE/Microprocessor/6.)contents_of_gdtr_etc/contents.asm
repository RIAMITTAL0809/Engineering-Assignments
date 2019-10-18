%macro scall 4
mov rax,%1
mov rdi,%2
mov rsi,%3
mov rdx,%4
syscall
%endmacro

section .data

m1 db "Protected mode is enabled",10
m1l equ $-m1

m2 db "Already in Protected mode ",10
m2l equ $-m2

m3 db "the contents of GDTR are ",10
m3l equ $-m3

m4 db "the contents of LDTR are",10
m4l equ $-m4

m5 db "the contents of IDTR are",10
m5l equ $-m5

m6 db "the contents of TR are",10
m6l equ $-m6

m7 db ":"
m7l equ $-m7

m8 db "",10
m8l equ $-m8

section .bss

gdtr resb 6
idtr resb 6
ldtr resb 2
tr   resb 2
buf  resb 4


section .text

display:
	
ab:
	rol rbx,04
	mov dl,bl
	and dl,0fh
	cmp dl,09h
	jbe nex
	add dl,07h
nex:	add dl,30h
	mov [rsi],dl
	inc rsi
	dec rcx 
	jnz ab
	ret
	


global _start
_start:
	
	smsw eax
	bt eax,31
	jc l1
	jmp abc
	mov rdx,0h
l1: 	scall 1,1,m2,m2l

abc:	sgdt [gdtr]
	sidt [idtr]
	sldt [ldtr]
	str  [tr]
	scall 1,1,m3,m3l
	
	mov bx,[gdtr+4]
	mov rsi,gdtr
	mov rcx,4
	call display
	scall 1,1,gdtr,4
	scall 1,1,m7,m7l
	
	
	mov bx,[gdtr+2]
	mov rsi,gdtr
	mov rcx,4
	call display
	scall 1,1,gdtr,4
	scall 1,1,m7,m7l
	
	
	mov bx,[gdtr]
	mov rsi,gdtr
	mov rcx,4
	call display
	scall 1,1,gdtr,4
	
	scall 1,1,m8,m8l
	
	scall 1,1,m5,m5l
	
	mov bx,[idtr+4]
	mov rsi,idtr
	mov rcx,4
	call display
	scall 1,1,idtr,4
	scall 1,1,m7,m7l
	
	
	mov bx,[idtr+2]
	mov rsi,idtr
	mov rcx,4
	call display
	scall 1,1,idtr,4
	scall 1,1,m7,m7l
	
	
	mov bx,[idtr]
	mov rsi,idtr
	mov rcx,4
	call display
	scall 1,1,idtr,4
	
	scall 1,1,m8,m8l
	
	scall 1,1,m4,m4l
	mov bx,[ldtr]
	mov rsi,ldtr
	mov rcx,4
	call display
	scall 1,1,ldtr,4
	
	scall 1,1,m8,m8l
	
	
exit: 	mov rax,60
	mov rdi,0
	syscall
