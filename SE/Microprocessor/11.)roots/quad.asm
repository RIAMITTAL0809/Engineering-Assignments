%macro scall 4 
mov rax,%1 
mov rdi,%2 
mov rsi,%3 
mov rdx,%4 
syscall
%endmacro
;-----------------------------------------------------------------------
section .data

m1 db "Complex Root",10 
l1 equ $-m1
m2 db 10,"Root1: " 
l2 equ $-m2
m3 db 10,"Root2: " 
l3 equ $-m3
new db 10
newl equ $-new

a dd 1.00 
b dd 8.00 
c dd 15.00 
four dd 4.00 
two dd 2.00
hdec dq 100
point db "."
;------------------------------------------------------------------------------
section .bss
root1 resd 1 
root2 resd 1 
resbuff rest 1 
temp resb 2
disc resd 1

;-----------------------------------------------------------------------------
section .text  
 global _start  
  _start:
  
  finit   	
  fld dword[b]
  fmul dword[b] 
  fld dword[a]	
  fmul dword[c] 	
  fmul dword[four]
  fsub	 	
  ftst 	   
   
  fstsw ax	
  sahf 
  jb no_real_solutions 	
  fsqrt 	
  fst dword[disc] 	
  fsub dword[b] 	
  fdiv dword[a] 	
  fdiv dword[two]
  scall 1,1,m2,l2  
  call disp_proc 	
  fldz	
  fsub dword[disc]	
  fsub dword[b] 	
  fdiv dword[a]   
  fdiv dword[two]	
  
  scall 1,1,m3,l3   
  call disp_proc
  scall 1,1,new,newl 
  jmp exi

no_real_solutions:

		scall 1,1,m1,l1
exi :
	scall 1,1,new,newl 
	mov rax,60 
	mov rdi,1
	syscall
  
disp_proc:
	FIMUL dword[hdec] 
	FBSTP tword[resbuff]
	mov rsi,resbuff+9 
	mov rcx,09

next1:	  
	  	push rcx
	  	push rsi
	 
	  	mov bl,[rsi]
	  	call disp
	  
	  	pop rsi
	  	pop rcx
	  
	   	dec rsi 
	   	loop next1
	     push rsi
	  	scall 1,1,point,1
	     pop rsi
	   	mov bl,[rsi]
	  	call disp
	     ret
	  
disp:	
	    	mov edi,temp	
	    	mov ecx,02     
	    	
dispup1:	
    		  rol bl,4	
	       mov dl,bl	
	       and dl,0fh	
	       add dl,30h	
	       cmp dl,39h	
	       jbe dispskip1	
	       add dl,07h            
dispskip1:	
           mov [edi],dl	
           inc edi	
           loop dispup1	
	      scall 1,1,temp,2	
	      ret	

