section .data
	menu1 db 10,"----MENU----"
           db 10,"1)Non Overlapping withOUT String"
	      db 10,"2)Non Overlapping with String"
	      db 10,"3)Exit"
	menu1_len equ $-menu1

	m1 db 10,"Block contents before transfer are="
	m1_l1 equ $-m1
	
	m2 db 10,"Block contents after transfer are="
	m2_l2 equ $-m2
 	
	m3 db 10,"Source Block contents are="
	m3_l3 equ $-m3

	m4 db 10,"Destination Block contents are="
	m4_l4 equ $-m4

	m5 db 10,"Do you want to continue="
	m5_l5 equ $-m5

	m6 db 10,"Enter your choice=",10
	m6_l6 equ $-m6

	srcblk db 11h,12h,13h,14h,15h	;declare source array of 5 elements

	dstblk times 5 db 0		
	cnt equ 05

	
	spacechar db 20h		;spaces between no.s
	lfmsg db 10			;new line
;--------------------------------------------------------------------------------
section .bss
	choice resb 02			;to accept choice
	dispbuff resb 02		;
;----------------------macro for accept and display-----------------------
%macro scall 4
	mov rax,%1
	mov rdi,%2
	mov rsi,%3
	mov rdx,%4
	syscall
%endmacro

;-------------------macro for exit---------------------------------
%macro exit 0
	mov rax,60
	xor rdi,rdi
	syscall
%endmacro
;--------------------------------------------------------------------
section .text
global _start
_start:
	scall 01,01,m1,m1_l1
	
	call showblks			;call showblk procedure before transfer

;--------------------ACCEPT MENU FROM USER-----------------------------------
menu:	
	scall 01,01,menu1,menu1_len
	scall 01,01,m6,m6_l6

	scall 0,0,choice,02

	mov al,byte[choice]

	cmp al,'1'
	jne case2

	call nwstr	;NONOVERLAPPING WITHOUT STRING

	jmp cont		;continue label

case2:	cmp al,'2'
	jne case3
	
	call nstr	;NONOVERLAPPING WITH STRING
	jmp cont

case3:
	cmp al,'3'
	je exit
	jmp cont

cont:						;DO you want to continue
	scall 01,01,m5,m5_l5

	scall 0,0,choice,02
	
	mov al,byte[choice]

	cmp al,'y'
	je menu
	jmp exit


;--------------DISPLAY Source and Destination BLOCKS-----------------
showblks:
	scall 01,01,m3,m3_l3

	mov rbx,srcblk
	call dispblk_proc

	scall 01,01,m4,m4_l4

	mov rbx,dstblk
	call dispblk_proc
ret

;
dispblk_proc:
	
	mov rcx,05
rdisp:
	push rcx
	mov dl,[rbx]

	call disp8_proc
	inc rbx
	scall 01,01,spacechar,01
	pop rcx

	loop rdisp
ret

;-----------DISPLAY 2 digit Number-----------------------------
disp8_proc:
	mov rcx,02
	mov rdi,dispbuff
dup1:
	rol dl,04
	mov al,dl
	and al,0fh

	cmp al,09h
	jbe L1
	add al,07
L1:	add al,30h

	mov [rdi],al
	inc rdi

	loop dup1

	scall 01,01,dispbuff,02
ret

;------------------NONOVERLAP WITHOUT STRING-----------------------	
nwstr:
	mov rsi,srcblk
	mov rdi,dstblk

	mov rcx,05
	
UP1:
	mov al,[rsi]
	mov [rdi],al
	inc rsi
	inc rdi

	loop UP1
	scall 01,01,m2,m2_l2	
	call showblks
ret

;------------------NONOVERLAP WITH STRING INSTRUCTIONS-----------------------	;------------------

nstr:
	mov rsi,srcblk
	mov rdi,dstblk

	mov rcx,05
	
	cld
	rep movsb

	scall 01,01,m2,m2_l2
	call showblks
ret
;--------------------------------------------------------------------------------







