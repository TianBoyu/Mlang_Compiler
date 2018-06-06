global    main
global    n
global    exchange
global    adjustHeap
global    makeHeap
global    a
global    heapSort


section .data
extern scanf
extern printf
extern puts
extern strlen
extern memcpy
extern sscanf
extern sprintf
extern malloc
extern strcmp

section .text

exchange:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  80
       mov  r12,  rdi
       mov  r11,  rsi
       mov  r15,  qword[a]
       mov  rbx,  r15
       mov  r14,  r12
       add  r14,  1
       mov  r8,  qword [rbx + r14 * 8]
       mov  rbx,  r8
       mov  r9,  qword[a]
       mov  r13,  r9
       mov  rcx,  qword[a]
       mov  r10,  rcx
       mov  r15,  r11
       add  r15,  1
       mov  r14,  qword [r10 + r15 * 8]
       mov  r8,  r12
       add  r8,  1
       mov  qword [r13 + r8 * 8],  r14
       mov  r9,  qword[a]
       mov  r10,  r9
       mov  rcx,  r11
       add  rcx,  1
       mov  qword [r10 + rcx * 8],  rbx
       add  rsp,  80
       pop  rbp
       ret  
       add  rsp,  80
       pop  rbp
       ret  
makeHeap:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  272
       mov  r15,  qword[n]
       mov  rbx,  r15
       sub  rbx,  1
       mov  rbx,  rbx
       mov  rax,  rbx
       mov  r14,  2
       mov  rdx,  0
       idiv  r14
       mov  rbx,  rax
       mov  qword [rbp-8],  rbx
       mov  rbx,  0
       mov  rbx,  0
       jmp  label2
label2:
       mov  r8,  qword [rbp-8]
       cmp  r8,  0
       jl  label4
label3:
       mov  rbx,  1
       jmp  label5
label4:
       mov  rbx,  0
       jmp  label5
label5:
       cmp  rbx,  0
       jz  label1
label0:
       mov  r9,  qword [rbp-8]
       mov  rbx,  r9
       imul  rbx,  2
       mov  rbx,  rbx
       mov  rcx,  qword [rbp-8]
       mov  r11,  rcx
       imul  r11,  2
       mov  r11,  r11
       add  r11,  1
       mov  r15,  qword[n]
       cmp  r11,  r15
       jge  label15
label14:
       mov  r11,  1
       jmp  label16
label15:
       mov  r11,  0
       jmp  label16
label16:
       cmp  r11,  0
       jz  label12
label9:
       mov  r14,  qword [rbp-8]
       mov  r11,  r14
       imul  r11,  2
       mov  r11,  r11
       add  r11,  1
       mov  r8,  qword[a]
       mov  qword [rbp-16],  r8
       mov  r9,  qword [rbp-8]
       mov  r12,  r9
       imul  r12,  2
       mov  rcx,  qword[a]
       mov  r13,  rcx
       mov  r15,  qword [rbp-16]
       mov  r14,  r11
       add  r14,  1
       mov  r8,  qword [r15 + r14 * 8]
       mov  r9,  r12
       add  r9,  1
       mov  rcx,  qword [r13 + r9 * 8]
       cmp  r8,  rcx
       jge  label18
label17:
       mov  r11,  1
       jmp  label19
label18:
       mov  r11,  0
       jmp  label19
label19:
       cmp  r11,  0
       jz  label12
label11:
       mov  r11,  1
       jmp  label13
label12:
       mov  r11,  0
       jmp  label13
label13:
       cmp  r11,  0
       jz  label7
label6:
       mov  r15,  qword [rbp-8]
       mov  rbx,  r15
       imul  rbx,  2
       mov  rbx,  rbx
       add  rbx,  1
       mov  rbx,  rbx
       jmp  label8
label7:
       jmp  label8
label8:
       mov  r14,  qword[a]
       mov  r11,  r14
       mov  r8,  qword[a]
       mov  r12,  r8
       mov  r9,  qword [rbp-8]
       mov  rcx,  r9
       add  rcx,  1
       mov  r15,  qword [r11 + rcx * 8]
       mov  r14,  rbx
       add  r14,  1
       mov  r8,  qword [r12 + r14 * 8]
       cmp  r15,  r8
       jle  label24
label23:
       mov  r11,  1
       jmp  label25
label24:
       mov  r11,  0
       jmp  label25
label25:
       cmp  r11,  0
       jz  label21
label20:
       push  r12
       push  r13
       push  r10
       push  r11
       push  rbx
       push  rbp
       mov  rdi,  qword [rbp-8]
       call  toString
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       pop  r13
       pop  r12
       mov  r11,  rax
       push  r12
       push  r13
       push  r10
       push  r11
       push  rbx
       push  rbp
       mov  rdi,  r11
       mov  rsi,  String_0
       call  Str_ADD
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       pop  r13
       pop  r12
       mov  r11,  rax
       push  r12
       push  r13
       push  r10
       push  r11
       push  rbx
       push  rbp
       mov  rdi,  rbx
       call  toString
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       pop  r13
       pop  r12
       mov  r12,  rax
       push  r12
       push  r13
       push  r10
       push  r11
       push  rbx
       push  rbp
       mov  rdi,  r11
       mov  rsi,  r12
       call  Str_ADD
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       pop  r13
       pop  r12
       mov  r11,  rax
       push  r12
       push  r13
       push  r10
       push  r11
       push  rbx
       push  rbp
       mov  rdi,  r11
       call  println
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       pop  r13
       pop  r12
       push  r12
       push  r13
       push  r10
       push  r11
       push  rbx
       push  rbp
       mov  rdi,  qword [rbp-8]
       mov  rsi,  rbx
       call  exchange
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       pop  r13
       pop  r12
       push  r12
       push  r13
       push  r10
       push  r11
       push  rbx
       push  rbp
       mov  rdi,  qword [rbp-8]
       call  toString
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       pop  r13
       pop  r12
       mov  r11,  rax
       push  r12
       push  r13
       push  r10
       push  r11
       push  rbx
       push  rbp
       mov  rdi,  r11
       mov  rsi,  String_1
       call  Str_ADD
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       pop  r13
       pop  r12
       mov  r11,  rax
       push  r12
       push  r13
       push  r10
       push  r11
       push  rbx
       push  rbp
       mov  rdi,  rbx
       call  toString
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       pop  r13
       pop  r12
       mov  rbx,  rax
       push  r12
       push  r13
       push  r10
       push  r11
       push  rbx
       push  rbp
       mov  rdi,  r11
       mov  rsi,  rbx
       call  Str_ADD
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       pop  r13
       pop  r12
       mov  rbx,  rax
       push  r12
       push  r13
       push  r10
       push  r11
       push  rbx
       push  rbp
       mov  rdi,  rbx
       call  println
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       pop  r13
       pop  r12
       jmp  label22
label21:
       jmp  label22
label22:
       mov  r9,  qword [rbp-8]
       mov  rbx,  r9
       sub  rbx,  1
       mov  qword [rbp-8],  rbx
       jmp  label2
label1:
       mov  rax,  0
       add  rsp,  272
       pop  rbp
       ret  
       add  rsp,  272
       pop  rbp
       ret  
adjustHeap:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  240
       mov  qword [rbp-8],  rdi
       mov  r11,  0
       mov  r10,  0
       mov  rbx,  0
       jmp  label28
label28:
       mov  rbx,  r11
       imul  rbx,  2
       mov  rcx,  qword [rbp-8]
       cmp  rbx,  rcx
       jge  label30
label29:
       mov  rbx,  1
       jmp  label31
label30:
       mov  rbx,  0
       jmp  label31
label31:
       cmp  rbx,  0
       jz  label27
label26:
       mov  rbx,  r11
       imul  rbx,  2
       mov  r10,  rbx
       mov  rbx,  r11
       imul  rbx,  2
       mov  rbx,  rbx
       add  rbx,  1
       mov  r15,  qword [rbp-8]
       cmp  rbx,  r15
       jge  label41
label40:
       mov  rbx,  1
       jmp  label42
label41:
       mov  rbx,  0
       jmp  label42
label42:
       cmp  rbx,  0
       jz  label38
label35:
       mov  rbx,  r11
       imul  rbx,  2
       mov  rbx,  rbx
       add  rbx,  1
       mov  r14,  qword[a]
       mov  r13,  r14
       mov  qword [rbp-16],  r11
       mov  r8,  qword [rbp-16]
       mov  r9,  r8
       imul  r9,  2
       mov  qword [rbp-16],  r9
       mov  rcx,  qword[a]
       mov  r12,  rcx
       mov  r15,  rbx
       add  r15,  1
       mov  r14,  qword [r13 + r15 * 8]
       mov  r8,  qword [rbp-16]
       mov  r9,  r8
       add  r9,  1
       mov  rcx,  qword [r12 + r9 * 8]
       cmp  r14,  rcx
       jge  label44
label43:
       mov  rbx,  1
       jmp  label45
label44:
       mov  rbx,  0
       jmp  label45
label45:
       cmp  rbx,  0
       jz  label38
label37:
       mov  rbx,  1
       jmp  label39
label38:
       mov  rbx,  0
       jmp  label39
label39:
       cmp  rbx,  0
       jz  label33
label32:
       mov  rbx,  r11
       imul  rbx,  2
       mov  rbx,  rbx
       add  rbx,  1
       mov  r10,  rbx
       jmp  label34
label33:
       jmp  label34
label34:
       mov  r15,  qword[a]
       mov  r12,  r15
       mov  r14,  qword[a]
       mov  rbx,  r14
       mov  r8,  r11
       add  r8,  1
       mov  r9,  qword [r12 + r8 * 8]
       mov  rcx,  r10
       add  rcx,  1
       mov  r15,  qword [rbx + rcx * 8]
       cmp  r9,  r15
       jle  label50
label49:
       mov  rbx,  1
       jmp  label51
label50:
       mov  rbx,  0
       jmp  label51
label51:
       cmp  rbx,  0
       jz  label47
label46:
       mov  r14,  qword[a]
       mov  rbx,  r14
       mov  r8,  r11
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  r12,  r9
       mov  rcx,  qword[a]
       mov  rbx,  rcx
       mov  r15,  qword[a]
       mov  r13,  r15
       mov  r14,  r10
       add  r14,  1
       mov  r8,  qword [r13 + r14 * 8]
       mov  r9,  r11
       add  r9,  1
       mov  qword [rbx + r9 * 8],  r8
       mov  rcx,  qword[a]
       mov  rbx,  rcx
       mov  r15,  r10
       add  r15,  1
       mov  qword [rbx + r15 * 8],  r12
       mov  r11,  r10
       jmp  label48
label47:
       jmp  label27
       jmp  label48
label48:
       jmp  label28
label27:
       mov  rax,  0
       add  rsp,  240
       pop  rbp
       ret  
       add  rsp,  240
       pop  rbp
       ret  
heapSort:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  144
       mov  r12,  0
       mov  r10,  0
       jmp  label54
label54:
       mov  r14,  qword[n]
       cmp  r10,  r14
       jge  label57
label56:
       mov  rbx,  1
       jmp  label58
label57:
       mov  rbx,  0
       jmp  label58
label58:
       cmp  rbx,  0
       jz  label53
label52:
       push  r12
       push  r13
       push  r10
       push  r11
       push  rbx
       push  rbp
       mov  rdi,  r10
       call  toString
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       pop  r13
       pop  r12
       mov  rbx,  rax
       push  r12
       push  r13
       push  r10
       push  r11
       push  rbx
       push  rbp
       mov  rdi,  rbx
       call  println
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       pop  r13
       pop  r12
       mov  r8,  qword[a]
       mov  rbx,  r8
       mov  r9,  qword [rbx + 8]
       mov  r12,  r9
       mov  rcx,  qword[a]
       mov  r13,  rcx
       mov  r15,  qword[n]
       mov  rbx,  r15
       sub  rbx,  r10
       mov  rbx,  rbx
       sub  rbx,  1
       mov  r14,  qword[a]
       mov  r11,  r14
       mov  r8,  rbx
       add  r8,  1
       mov  r9,  qword [r11 + r8 * 8]
       mov  qword [r13 + 8],  r9
       mov  rcx,  qword[n]
       mov  rbx,  rcx
       sub  rbx,  r10
       mov  r11,  rbx
       sub  r11,  1
       mov  r15,  qword[a]
       mov  rbx,  r15
       mov  r14,  r11
       add  r14,  1
       mov  qword [rbx + r14 * 8],  r12
       mov  r8,  qword[n]
       mov  rbx,  r8
       sub  rbx,  r10
       mov  rbx,  rbx
       sub  rbx,  1
       push  r12
       push  r13
       push  r10
       push  r11
       push  rbx
       push  rbp
       mov  rdi,  rbx
       call  adjustHeap
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       pop  r13
       pop  r12
       mov  rbx,  rax
       jmp  label55
label55:
       mov  rbx,  r10
       add  rbx,  1
       mov  r10,  rbx
       jmp  label54
label53:
       mov  rax,  0
       add  rsp,  144
       pop  rbp
       ret  
       add  rsp,  144
       pop  rbp
       ret  
main:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  144
       push  r10
       push  r11
       push  rbx
       push  rbp
       call  getString
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       mov  rbx,  rax
       push  r10
       push  r11
       push  rbx
       push  rbp
       mov  rdi,  rbx
       call  parseInt
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       mov  rbx,  rax
       mov  qword[n],  rbx
       mov  r9,  qword[n]
       add  r9,  1
       imul  r9,  8
       mov  rdi,  r9
       push  r10
       push  r11
       push  rbx
       push  rbp
       call  malloc
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       mov  rbx,  rax
       mov  rcx,  qword[n]
       mov  qword [rbx + 0],  rcx
       mov  qword[a],  rbx
       mov  r11,  0
       jmp  label61
label61:
       push  r10
       push  r11
       push  rbx
       push  rbp
       mov  rdi,  qword[a]
       call  size
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       mov  rbx,  rax
       cmp  r11,  rbx
       jge  label64
label63:
       mov  rbx,  1
       jmp  label65
label64:
       mov  rbx,  0
       jmp  label65
label65:
       cmp  rbx,  0
       jz  label60
label59:
       mov  r15,  qword[a]
       mov  rbx,  r15
       mov  r14,  r11
       add  r14,  1
       mov  qword [rbx + r14 * 8],  r11
       jmp  label62
label62:
       mov  rbx,  r11
       add  rbx,  1
       mov  r11,  rbx
       jmp  label61
label60:
       push  r10
       push  r11
       push  rbx
       push  rbp
       call  makeHeap
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       mov  rbx,  rax
       push  r10
       push  r11
       push  rbx
       push  rbp
       call  heapSort
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       mov  rbx,  rax
       mov  r11,  0
       jmp  label68
label68:
       push  r10
       push  r11
       push  rbx
       push  rbp
       mov  rdi,  qword[a]
       call  size
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       mov  rbx,  rax
       cmp  r11,  rbx
       jge  label71
label70:
       mov  rbx,  1
       jmp  label72
label71:
       mov  rbx,  0
       jmp  label72
label72:
       cmp  rbx,  0
       jz  label67
label66:
       mov  r8,  qword[a]
       mov  rbx,  r8
       push  r10
       push  r11
       push  rbx
       push  rbp
       mov  r9,  r11
       add  r9,  1
       mov  rdi,  qword [rbx + r9 * 8]
       call  toString
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       mov  rbx,  rax
       push  r10
       push  r11
       push  rbx
       push  rbp
       mov  rdi,  rbx
       mov  rsi,  String_2
       call  Str_ADD
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       mov  rbx,  rax
       push  r10
       push  r11
       push  rbx
       push  rbp
       mov  rdi,  rbx
       call  print
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       jmp  label69
label69:
       mov  rbx,  r11
       add  rbx,  1
       mov  r11,  rbx
       jmp  label68
label67:
       push  r10
       push  r11
       push  rbx
       push  rbp
       mov  rdi,  String_3
       call  print
       pop  rbp
       pop  rbx
       pop  r11
       pop  r10
       mov  rax,  0
       add  rsp,  144
       pop  rbp
       ret  
       add  rsp,  144
       pop  rbp
       ret  

section .data
       dq  1
String_0:
       db  32, 0
       dq  1
String_1:
       db  32, 0
       dq  1
String_2:
       db  32, 0
       dq  1
String_3:
       db  10, 0

section .bss

n:       resq  1
a:       resq  1


section .data
intbuffer:
    dq 0
format1:
    db"%lld",0
format2:
    db"%lld ",10,0
format3:
    db"%s",0
format4:
    db"%s",10,0

section .bss
stringbuffer:
    resb 256

section .text
getInt:

    push rbp
    mov rbp,rsp
    mov rax,0
    mov rdi,format1
    mov rsi,intbuffer
    call scanf
    mov rax,[intbuffer]
    mov rsp,rbp
    pop rbp
    ret

printInt:
    push rbp
    mov rbp,rsp
    mov rsi,rdi
    mov rax,0
    mov rdi,format2
    call printf
    mov rsp,rbp
    pop rbp
    ret

size:
    mov rax,[rdi]
    ret

print:
    push rbp
    mov rbp,rsp
    mov rax,0
    mov rsi,rdi
    mov rdi,format3
    call printf
    mov rsp,rbp
    pop rbp
    ret

println:

    call puts
    ret


transtring:

    push rbp
    mov rbp,rsp
    call strlen
    push rdi
    mov rdi,rax
    push rdi
    add rdi,9
    call malloc
    pop rdi
    mov [rax],rdi
    add rax,8
    mov rdx,rdi
    add rdx,1
    mov rdi,rax
    pop rsi
    sub rsp,8
    push rax
    call memcpy
    pop rax
    mov rsp,rbp
    pop rbp
    ret

getString:

    push rbp
    mov rbp,rsp
    mov rax,0
    mov rdi,format3
    mov rsi,stringbuffer
    call scanf
    mov rdi,stringbuffer
    call transtring
    mov rsp,rbp
    pop rbp
    ret


ALIGN   16

toString:
        push    rbx
        mov     rbx, rdi
        mov     edi, 20
        call    malloc
        test    rbx, rbx
        mov     r9, rax
        lea     rdi, [rax+8H]
        js      L_007
        jne     L_010
        lea     rcx, [rax+9H]
        mov     byte [rax+8H], 48
        mov     rsi, rcx
L_004:  mov     rax, rcx
        mov     byte [rcx], 0
        sub     rax, rdi
        mov     qword [r9], rax
        lea     rax, [rcx-1H]
        cmp     rax, rsi
        jc      L_006
L_005:  movzx   edx, byte [rsi]
        movzx   ecx, byte [rax]
        add     rsi, 1
        sub     rax, 1
        mov     byte [rsi-1H], cl
        mov     byte [rax+1H], dl
        cmp     rsi, rax
        jbe     L_005
L_006:  mov     rax, rdi
        pop     rbx
        ret





ALIGN   8
L_007:  lea     rsi, [rax+9H]
        mov     byte [rax+8H], 45
        neg     rbx
L_008:  mov     rcx, rsi
        mov     r8, qword 6666666666666667H




ALIGN   16
L_009:  mov     rax, rbx
        add     rcx, 1
        imul    r8
        mov     rax, rbx
        add     ebx, 48
        sar     rax, 63
        sar     rdx, 2
        sub     rdx, rax
        lea     eax, [rdx+rdx*4]
        add     eax, eax
        sub     ebx, eax
        test    rdx, rdx
        mov     byte [rcx-1H], bl
        mov     rbx, rdx
        jnz     L_009
        jmp     L_004





ALIGN   8
L_010:  mov     rsi, rdi
        jmp     L_008



length:

    mov rax,[rdi-8]
    ret


ALIGN   8

substring:
        push    r13
        sub     rdx, rsi
        push    r12
        push    rbp
        push    rbx
        mov     r12, rdi
        lea     rbx, [rdx+1H]
        lea     rdi, [rdx+0AH]
        mov     rbp, rsi
        sub     rsp, 8
        call    malloc
        test    rbx, rbx
        mov     r13, rax
        mov     qword [rax], rbx
        lea     rcx, [rax+8H]
        jle     L_003
        lea     rsi, [r12+rbp]
        mov     rdi, rcx
        mov     rdx, rbx
        call    memcpy
        mov     rcx, rax
L_003:  mov     byte [r13+rbx+8H], 0
        add     rsp, 8
        mov     rax, rcx
        pop     rbx
        pop     rbp
        pop     r12
        pop     r13
        ret


        nop


parseInt:

    mov rsi,format1
    mov rdx,intbuffer
    mov rax,0
    call sscanf
    mov rax,[intbuffer]
    ret

ord:

    mov rax,0
    mov al,byte[rdi+rsi]
    ret

Str_ADD:
        push    r15
        push    r14
        mov     r15, rdi
        push    r13
        push    r12
        mov     r14, rsi
        push    rbp
        push    rbx
        sub     rsp, 8
        mov     rbp, qword [rdi-8H]
        mov     r12, qword [rsi-8H]
        lea     rbx, [rbp+r12]
        lea     rdi, [rbx+9H]
        call    malloc
        test    rbp, rbp
        mov     qword [rax], rbx
        mov     r13, rax
        lea     rbx, [rax+8H]
        jle     L_001
        mov     rdx, rbp
        mov     rsi, r15
        mov     rdi, rbx
        call    memcpy
L_001:  add     rbx, rbp
        test    r12, r12
        jle     L_002
        lea     rdi, [r13+rbp+8H]
        mov     rdx, r12
        mov     rsi, r14
        call    memcpy
L_002:  mov     byte [rbx+r12], 0
        mov     rax, rbx
        add     rsp, 8
        pop     rbx
        sub     rax, rbp
        pop     rbp
        pop     r12
        pop     r13
        pop     r14
        pop     r15
        ret


Str_LT:

    push rbp
    mov rbp,rsp
    call strcmp
    mov rdi,0
    cmp rax,0
    setl dil
    mov rax,rdi
    mov rsp,rbp
    pop rbp
    ret

Str_LE:

    push rbp
    mov rbp,rsp
    call strcmp
    mov rdi,0
    cmp rax,0
    setle dil
    mov rax,rdi
    mov rsp,rbp
    pop rbp
    ret

Str_GT:

    push rbp
    mov rbp,rsp
    call strcmp
    mov rdi,0
    cmp rax,0
    setg dil
    mov rax,rdi
    mov rsp,rbp
    pop rbp
    ret

Str_GE:

    push rbp
    mov rbp,rsp
    call strcmp
    mov rdi,0
    cmp rax,0
    setge dil
    mov rax,rdi
    mov rsp,rbp
    pop rbp
    ret

Str_EQ:

    push rbp
    mov rbp,rsp
    call strcmp
    mov rdi,0
    cmp rax,0
    sete dil
    mov rax,rdi
    mov rsp,rbp
    pop rbp
    ret

Str_NE:

    push rbp
    mov rbp,rsp
    call strcmp
    mov rdi,0
    cmp rax,0
    setne dil
    mov rax,rdi
    mov rsp,rbp
    pop rbp
    ret
