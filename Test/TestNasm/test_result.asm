global    func
global    main


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

func:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  80
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  qword [rbp-24],  rdx
       mov  rax,  qword [rbp-8]
       mov  rdx,  qword [rbp-16]
       add  rax,  rdx
       mov  qword [rbp-32],  rax
       mov  rax,  qword [rbp-32]
       mov  rdx,  qword [rbp-24]
       add  rax,  rdx
       mov  qword [rbp-40],  rax
       mov  rax,  1
       mov  rcx,  30
       shl  rax,  cl
       mov  qword [rbp-48],  rax
       mov  rax,  qword [rbp-48]
       sub  rax,  1
       mov  qword [rbp-56],  rax
       mov  rax,  qword [rbp-40]
       mov  rdx,  qword [rbp-56]
       and  rax,  rdx
       mov  qword [rbp-64],  rax
       mov  rax,  qword [rbp-64]
       add  rsp,  80
       pop  rbp
       ret  
       add  rsp,  80
       pop  rbp
       ret  
main:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  336
       call  getInt
       mov  qword [rbp-16],  rax
       mov  rax,  qword [rbp-16]
       mov  qword [rbp-8],  rax
       mov  rcx,  qword [rbp-8]
       mov  r15,  rcx
       add  r15,  1
       imul  r15,  8
       mov  rdi,  r15
       call  malloc
       mov  qword [rbp-32],  rax
       mov  rcx,  qword [rbp-8]
       mov  rax,  qword [rbp-32]
       mov  qword [rax + 0],  rcx
       mov  qword [rbp-40],  0
label0:
       mov  rcx,  qword [rbp-8]
       mov  r15,  rcx
       add  r15,  1
       imul  r15,  8
       mov  rdi,  r15
       call  malloc
       mov  rcx,  qword [rbp-32]
       mov  rdx,  qword [rbp-40]
       add  rdx,  1
       mov  qword [rcx + rdx * 8],  rax
       mov  rbx,  qword [rbp-8]
       mov  rcx,  qword [rbp-32]
       mov  rdx,  qword [rbp-40]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  qword [rax + 0],  rbx
       mov  qword [rbp-48],  0
       mov  rax,  qword [rbp-40]
       add  rax,  1
       mov  qword [rbp-40],  rax
       mov  rcx,  qword [rbp-40]
       mov  rdx,  qword [rbp-8]
       cmp  rcx,  rdx
       jg  label1
       jmp  label0
label1:
       mov  rax,  qword [rbp-32]
       mov  qword [rbp-24],  rax
       mov  rcx,  qword [rbp-8]
       mov  r15,  rcx
       add  r15,  1
       imul  r15,  8
       mov  rdi,  r15
       call  malloc
       mov  qword [rbp-72],  rax
       mov  rcx,  qword [rbp-8]
       mov  rax,  qword [rbp-72]
       mov  qword [rax + 0],  rcx
       mov  qword [rbp-80],  0
label4:
       mov  rcx,  qword [rbp-8]
       mov  r15,  rcx
       add  r15,  1
       imul  r15,  8
       mov  rdi,  r15
       call  malloc
       mov  rcx,  qword [rbp-72]
       mov  rdx,  qword [rbp-80]
       add  rdx,  1
       mov  qword [rcx + rdx * 8],  rax
       mov  rbx,  qword [rbp-8]
       mov  rcx,  qword [rbp-72]
       mov  rdx,  qword [rbp-80]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  qword [rax + 0],  rbx
       mov  qword [rbp-88],  0
       mov  rax,  qword [rbp-80]
       add  rax,  1
       mov  qword [rbp-80],  rax
       mov  rcx,  qword [rbp-80]
       mov  rdx,  qword [rbp-8]
       cmp  rcx,  rdx
       jg  label5
       jmp  label4
label5:
       mov  rax,  qword [rbp-72]
       mov  qword [rbp-64],  rax
       mov  rcx,  qword [rbp-8]
       mov  r15,  rcx
       add  r15,  1
       imul  r15,  8
       mov  rdi,  r15
       call  malloc
       mov  qword [rbp-112],  rax
       mov  rcx,  qword [rbp-8]
       mov  rax,  qword [rbp-112]
       mov  qword [rax + 0],  rcx
       mov  qword [rbp-120],  0
label8:
       mov  rcx,  qword [rbp-8]
       mov  r15,  rcx
       add  r15,  1
       imul  r15,  8
       mov  rdi,  r15
       call  malloc
       mov  rcx,  qword [rbp-112]
       mov  rdx,  qword [rbp-120]
       add  rdx,  1
       mov  qword [rcx + rdx * 8],  rax
       mov  rbx,  qword [rbp-8]
       mov  rcx,  qword [rbp-112]
       mov  rdx,  qword [rbp-120]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  qword [rax + 0],  rbx
       mov  qword [rbp-128],  0
       mov  rax,  qword [rbp-120]
       add  rax,  1
       mov  qword [rbp-120],  rax
       mov  rcx,  qword [rbp-120]
       mov  rdx,  qword [rbp-8]
       cmp  rcx,  rdx
       jg  label9
       jmp  label8
label9:
       mov  rax,  qword [rbp-112]
       mov  qword [rbp-104],  rax
       mov  qword [rbp-144],  0
label14:
       mov  rcx,  qword [rbp-144]
       mov  rdx,  qword [rbp-8]
       cmp  rcx,  rdx
       jge  label17
label16:
       mov  qword [rbp-168],  1
       jmp  label18
label17:
       mov  qword [rbp-168],  0
label18:
       mov  rcx,  qword [rbp-168]
       cmp  rcx,  0
       jz  label13
label12:
       mov  qword [rbp-152],  0
label21:
       mov  rcx,  qword [rbp-152]
       mov  rdx,  qword [rbp-8]
       cmp  rcx,  rdx
       jge  label24
label23:
       mov  qword [rbp-176],  1
       jmp  label25
label24:
       mov  qword [rbp-176],  0
label25:
       mov  rcx,  qword [rbp-176]
       cmp  rcx,  0
       jz  label20
label19:
       mov  rax,  qword [rbp-144]
       mov  rdx,  qword [rbp-152]
       add  rax,  rdx
       mov  qword [rbp-184],  rax
       mov  r8,  qword [rbp-184]
       mov  rdx,  qword [rbp-24]
       mov  rbx,  qword [rbp-144]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-152]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  r8
label22:
       mov  rax,  qword [rbp-152]
       add  rax,  1
       mov  qword [rbp-152],  rax
       jmp  label21
label20:
label15:
       mov  rax,  qword [rbp-144]
       add  rax,  1
       mov  qword [rbp-144],  rax
       jmp  label14
label13:
       mov  qword [rbp-144],  0
label28:
       mov  rcx,  qword [rbp-144]
       mov  rdx,  qword [rbp-8]
       cmp  rcx,  rdx
       jge  label31
label30:
       mov  qword [rbp-192],  1
       jmp  label32
label31:
       mov  qword [rbp-192],  0
label32:
       mov  rcx,  qword [rbp-192]
       cmp  rcx,  0
       jz  label27
label26:
       mov  qword [rbp-152],  0
label35:
       mov  rcx,  qword [rbp-152]
       mov  rdx,  qword [rbp-8]
       cmp  rcx,  rdx
       jge  label38
label37:
       mov  qword [rbp-200],  1
       jmp  label39
label38:
       mov  qword [rbp-200],  0
label39:
       mov  rcx,  qword [rbp-200]
       cmp  rcx,  0
       jz  label34
label33:
       mov  qword [rbp-160],  0
label42:
       mov  rcx,  qword [rbp-160]
       mov  rdx,  qword [rbp-8]
       cmp  rcx,  rdx
       jge  label45
label44:
       mov  qword [rbp-208],  1
       jmp  label46
label45:
       mov  qword [rbp-208],  0
label46:
       mov  rcx,  qword [rbp-208]
       cmp  rcx,  0
       jz  label41
label40:
       mov  rcx,  qword [rbp-152]
       mov  rdx,  qword [rbp-144]
       cmp  rcx,  rdx
       jl  label51
label50:
       mov  qword [rbp-216],  1
       jmp  label52
label51:
       mov  qword [rbp-216],  0
label52:
       mov  rcx,  qword [rbp-216]
       cmp  rcx,  0
       jz  label48
label47:
       mov  rdx,  qword [rbp-64]
       mov  rbx,  qword [rbp-144]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-152]
       add  rcx,  1
       mov  rax,  qword [rax + rcx * 8]
       mov  rdi,  rax
       mov  rdx,  qword [rbp-24]
       mov  rbx,  qword [rbp-144]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-160]
       add  rcx,  1
       mov  rax,  qword [rax + rcx * 8]
       mov  rsi,  rax
       mov  rdx,  qword [rbp-24]
       mov  rbx,  qword [rbp-160]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-152]
       add  rcx,  1
       mov  rax,  qword [rax + rcx * 8]
       mov  rdx,  rax
       call  func
       mov  qword [rbp-224],  rax
       mov  r8,  qword [rbp-224]
       mov  rdx,  qword [rbp-64]
       mov  rbx,  qword [rbp-144]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-152]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  r8
       mov  rdx,  qword [rbp-64]
       mov  rbx,  qword [rbp-144]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-152]
       add  rcx,  1
       mov  rax,  qword [rax + rcx * 8]
       mov  rdi,  rax
       mov  rdx,  qword [rbp-24]
       mov  rbx,  qword [rbp-144]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-160]
       add  rcx,  1
       mov  rax,  qword [rax + rcx * 8]
       mov  rsi,  rax
       mov  rdx,  qword [rbp-24]
       mov  rbx,  qword [rbp-160]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-152]
       add  rcx,  1
       mov  rax,  qword [rax + rcx * 8]
       mov  rdx,  rax
       call  func
       mov  qword [rbp-232],  rax
       mov  r8,  qword [rbp-232]
       mov  rdx,  qword [rbp-104]
       mov  rbx,  qword [rbp-144]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-152]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  r8
       mov  rdx,  qword [rbp-64]
       mov  rbx,  qword [rbp-144]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-152]
       add  rcx,  1
       mov  rax,  qword [rax + rcx * 8]
       mov  rdi,  rax
       mov  rdx,  qword [rbp-24]
       mov  rbx,  qword [rbp-144]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-160]
       add  rcx,  1
       mov  rax,  qword [rax + rcx * 8]
       mov  rsi,  rax
       mov  rdx,  qword [rbp-24]
       mov  rbx,  qword [rbp-160]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-152]
       add  rcx,  1
       mov  rax,  qword [rax + rcx * 8]
       mov  rdx,  rax
       call  func
       mov  qword [rbp-240],  rax
       mov  r8,  qword [rbp-240]
       mov  rdx,  qword [rbp-104]
       mov  rbx,  qword [rbp-144]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-152]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  r8
       mov  rdx,  qword [rbp-64]
       mov  rbx,  qword [rbp-144]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-152]
       add  rcx,  1
       mov  rax,  qword [rax + rcx * 8]
       mov  rdi,  rax
       mov  rdx,  qword [rbp-24]
       mov  rbx,  qword [rbp-144]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-160]
       add  rcx,  1
       mov  rax,  qword [rax + rcx * 8]
       mov  rsi,  rax
       mov  rdx,  qword [rbp-24]
       mov  rbx,  qword [rbp-160]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-152]
       add  rcx,  1
       mov  rax,  qword [rax + rcx * 8]
       mov  rdx,  rax
       call  func
       mov  qword [rbp-248],  rax
       mov  r8,  qword [rbp-248]
       mov  rdx,  qword [rbp-104]
       mov  rbx,  qword [rbp-144]
       add  rbx,  1
       mov  rax,  qword [rdx + rbx * 8]
       mov  rcx,  qword [rbp-152]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  r8
       jmp  label49
label48:
       jmp  label49
label49:
label43:
       mov  rax,  qword [rbp-160]
       add  rax,  1
       mov  qword [rbp-160],  rax
       jmp  label42
label41:
label36:
       mov  rax,  qword [rbp-152]
       add  rax,  1
       mov  qword [rbp-152],  rax
       jmp  label35
label34:
label29:
       mov  rax,  qword [rbp-144]
       add  rax,  1
       mov  qword [rbp-144],  rax
       jmp  label28
label27:
       mov  qword [rbp-256],  0
       mov  qword [rbp-144],  0
label55:
       mov  rcx,  qword [rbp-144]
       mov  rdx,  qword [rbp-8]
       cmp  rcx,  rdx
       jge  label58
label57:
       mov  qword [rbp-264],  1
       jmp  label59
label58:
       mov  qword [rbp-264],  0
label59:
       mov  rcx,  qword [rbp-264]
       cmp  rcx,  0
       jz  label54
label53:
       mov  qword [rbp-152],  0
label62:
       mov  rcx,  qword [rbp-152]
       mov  rdx,  qword [rbp-8]
       cmp  rcx,  rdx
       jge  label65
label64:
       mov  qword [rbp-272],  1
       jmp  label66
label65:
       mov  qword [rbp-272],  0
label66:
       mov  rcx,  qword [rbp-272]
       cmp  rcx,  0
       jz  label61
label60:
       mov  rax,  qword [rbp-256]
       mov  r8,  qword [rbp-64]
       mov  r9,  qword [rbp-144]
       add  r9,  1
       mov  rdx,  qword [r8 + r9 * 8]
       mov  rbx,  qword [rbp-152]
       add  rbx,  1
       mov  r10,  qword [rdx + rbx * 8]
       add  rax,  r10
       mov  qword [rbp-280],  rax
       mov  rax,  1
       mov  rcx,  30
       shl  rax,  cl
       mov  qword [rbp-288],  rax
       mov  rax,  qword [rbp-288]
       sub  rax,  1
       mov  qword [rbp-296],  rax
       mov  rax,  qword [rbp-280]
       mov  rdx,  qword [rbp-296]
       and  rax,  rdx
       mov  qword [rbp-304],  rax
       mov  rax,  qword [rbp-304]
       mov  qword [rbp-256],  rax
label63:
       mov  rax,  qword [rbp-152]
       add  rax,  1
       mov  qword [rbp-152],  rax
       jmp  label62
label61:
label56:
       mov  rax,  qword [rbp-144]
       add  rax,  1
       mov  qword [rbp-144],  rax
       jmp  label55
label54:
       mov  rax,  qword [rbp-256]
       mov  rdi,  rax
       call  toString
       mov  qword [rbp-312],  rax
       mov  rax,  qword [rbp-312]
       mov  rdi,  rax
       call  print
       mov  rax,  0
       add  rsp,  336
       pop  rbp
       ret  
       add  rsp,  336
       pop  rbp
       ret  

section .data

section .bss



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
