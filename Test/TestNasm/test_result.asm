global    dp
global    main
global    add


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

add:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  48
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  rax,  qword [rbp-8]
       mov  rdx,  qword [rbp-16]
       add  rax,  rdx
       mov  qword [rbp-24],  rax
       mov  rax,  qword [rbp-24]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-32],  rdx
       mov  rax,  qword [rbp-32]
       add  rsp,  48
       pop  rbp
       ret  
       add  rsp,  48
       pop  rbp
       ret  
dp:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  992
       mov  qword [rbp-8],  rdi
       mov  rcx,  qword [rbp-8]
       cmp  rcx,  1
       jg  label4
label3:
       mov  qword [rbp-16],  1
       jmp  label5
label4:
       mov  qword [rbp-16],  0
label5:
       mov  rcx,  qword [rbp-16]
       cmp  rcx,  0
       jz  label1
label0:
       mov  rax,  7
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-32],  rdx
       mov  rax,  qword [rbp-32]
       imul  rax,  7
       mov  qword [rbp-40],  rax
       mov  rax,  qword [rbp-40]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-48],  rdx
       mov  rax,  qword [rbp-48]
       imul  rax,  7
       mov  qword [rbp-56],  rax
       mov  rax,  qword [rbp-56]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-64],  rdx
       mov  rax,  qword [rbp-64]
       imul  rax,  7
       mov  qword [rbp-72],  rax
       mov  rax,  qword [rbp-72]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-80],  rdx
       mov  rax,  qword [rbp-80]
       imul  rax,  7
       mov  qword [rbp-88],  rax
       mov  rax,  qword [rbp-88]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-96],  rdx
       mov  rax,  qword [rbp-96]
       imul  rax,  7
       mov  qword [rbp-104],  rax
       mov  rax,  qword [rbp-104]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-112],  rdx
       mov  rax,  qword [rbp-112]
       imul  rax,  7
       mov  qword [rbp-120],  rax
       mov  rax,  qword [rbp-120]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-128],  rdx
       mov  rax,  qword [rbp-128]
       imul  rax,  7
       mov  qword [rbp-136],  rax
       mov  rax,  qword [rbp-136]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-144],  rdx
       mov  rax,  qword [rbp-144]
       imul  rax,  7
       mov  qword [rbp-152],  rax
       mov  rax,  qword [rbp-152]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-160],  rdx
       mov  rax,  qword [rbp-160]
       imul  rax,  7
       mov  qword [rbp-168],  rax
       mov  rax,  qword [rbp-168]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-176],  rdx
       mov  rax,  qword [rbp-176]
       imul  rax,  7
       mov  qword [rbp-184],  rax
       mov  rax,  qword [rbp-184]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-192],  rdx
       mov  rax,  qword [rbp-192]
       imul  rax,  7
       mov  qword [rbp-200],  rax
       mov  rax,  qword [rbp-200]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-208],  rdx
       mov  rax,  qword [rbp-208]
       imul  rax,  7
       mov  qword [rbp-216],  rax
       mov  rax,  qword [rbp-216]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-224],  rdx
       mov  rax,  qword [rbp-224]
       imul  rax,  7
       mov  qword [rbp-232],  rax
       mov  rax,  qword [rbp-232]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-240],  rdx
       mov  rax,  qword [rbp-240]
       imul  rax,  7
       mov  qword [rbp-248],  rax
       mov  rax,  qword [rbp-248]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-256],  rdx
       mov  rax,  qword [rbp-256]
       imul  rax,  7
       mov  qword [rbp-264],  rax
       mov  rax,  qword [rbp-264]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-272],  rdx
       mov  rax,  qword [rbp-272]
       imul  rax,  7
       mov  qword [rbp-280],  rax
       mov  rax,  qword [rbp-280]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-288],  rdx
       mov  rax,  qword [rbp-288]
       imul  rax,  7
       mov  qword [rbp-296],  rax
       mov  rax,  qword [rbp-296]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-304],  rdx
       mov  rax,  qword [rbp-304]
       imul  rax,  7
       mov  qword [rbp-312],  rax
       mov  rax,  qword [rbp-312]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-320],  rdx
       mov  rax,  qword [rbp-320]
       imul  rax,  7
       mov  qword [rbp-328],  rax
       mov  rax,  qword [rbp-328]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-336],  rdx
       mov  rax,  qword [rbp-336]
       imul  rax,  7
       mov  qword [rbp-344],  rax
       mov  rax,  qword [rbp-344]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-352],  rdx
       mov  rax,  qword [rbp-352]
       imul  rax,  7
       mov  qword [rbp-360],  rax
       mov  rax,  qword [rbp-360]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-368],  rdx
       mov  rax,  qword [rbp-368]
       imul  rax,  7
       mov  qword [rbp-376],  rax
       mov  rax,  qword [rbp-376]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-384],  rdx
       mov  rax,  qword [rbp-384]
       imul  rax,  7
       mov  qword [rbp-392],  rax
       mov  rax,  qword [rbp-392]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-400],  rdx
       mov  rax,  qword [rbp-400]
       imul  rax,  7
       mov  qword [rbp-408],  rax
       mov  rax,  qword [rbp-408]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-416],  rdx
       mov  rax,  qword [rbp-416]
       imul  rax,  7
       mov  qword [rbp-424],  rax
       mov  rax,  qword [rbp-424]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-432],  rdx
       mov  rax,  qword [rbp-432]
       imul  rax,  7
       mov  qword [rbp-440],  rax
       mov  rax,  qword [rbp-440]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-448],  rdx
       mov  rax,  qword [rbp-448]
       imul  rax,  7
       mov  qword [rbp-456],  rax
       mov  rax,  qword [rbp-456]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-464],  rdx
       mov  rax,  qword [rbp-464]
       imul  rax,  7
       mov  qword [rbp-472],  rax
       mov  rax,  qword [rbp-472]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-480],  rdx
       mov  rax,  qword [rbp-480]
       imul  rax,  7
       mov  qword [rbp-488],  rax
       mov  rax,  qword [rbp-488]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-496],  rdx
       mov  rax,  qword [rbp-496]
       imul  rax,  7
       mov  qword [rbp-504],  rax
       mov  rax,  qword [rbp-504]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-512],  rdx
       mov  rax,  qword [rbp-512]
       imul  rax,  7
       mov  qword [rbp-520],  rax
       mov  rax,  qword [rbp-520]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-528],  rdx
       mov  rax,  qword [rbp-528]
       imul  rax,  7
       mov  qword [rbp-536],  rax
       mov  rax,  qword [rbp-536]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-544],  rdx
       mov  rax,  qword [rbp-544]
       imul  rax,  7
       mov  qword [rbp-552],  rax
       mov  rax,  qword [rbp-552]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-560],  rdx
       mov  rax,  qword [rbp-560]
       imul  rax,  7
       mov  qword [rbp-568],  rax
       mov  rax,  qword [rbp-568]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-576],  rdx
       mov  rax,  qword [rbp-576]
       imul  rax,  7
       mov  qword [rbp-584],  rax
       mov  rax,  qword [rbp-584]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-592],  rdx
       mov  rax,  qword [rbp-592]
       imul  rax,  7
       mov  qword [rbp-600],  rax
       mov  rax,  qword [rbp-600]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-608],  rdx
       mov  rax,  qword [rbp-608]
       imul  rax,  7
       mov  qword [rbp-616],  rax
       mov  rax,  qword [rbp-616]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-624],  rdx
       mov  rax,  qword [rbp-624]
       imul  rax,  7
       mov  qword [rbp-632],  rax
       mov  rax,  qword [rbp-632]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-640],  rdx
       mov  rax,  qword [rbp-640]
       imul  rax,  7
       mov  qword [rbp-648],  rax
       mov  rax,  qword [rbp-648]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-656],  rdx
       mov  rax,  qword [rbp-656]
       imul  rax,  7
       mov  qword [rbp-664],  rax
       mov  rax,  qword [rbp-664]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-672],  rdx
       mov  rax,  qword [rbp-672]
       imul  rax,  7
       mov  qword [rbp-680],  rax
       mov  rax,  qword [rbp-680]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-688],  rdx
       mov  rax,  qword [rbp-688]
       imul  rax,  7
       mov  qword [rbp-696],  rax
       mov  rax,  qword [rbp-696]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-704],  rdx
       mov  rax,  qword [rbp-704]
       imul  rax,  7
       mov  qword [rbp-712],  rax
       mov  rax,  qword [rbp-712]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-720],  rdx
       mov  rax,  qword [rbp-720]
       imul  rax,  7
       mov  qword [rbp-728],  rax
       mov  rax,  qword [rbp-728]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-736],  rdx
       mov  rax,  qword [rbp-736]
       imul  rax,  7
       mov  qword [rbp-744],  rax
       mov  rax,  qword [rbp-744]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-752],  rdx
       mov  rax,  qword [rbp-752]
       imul  rax,  7
       mov  qword [rbp-760],  rax
       mov  rax,  qword [rbp-760]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-768],  rdx
       mov  rax,  qword [rbp-768]
       imul  rax,  7
       mov  qword [rbp-776],  rax
       mov  rax,  qword [rbp-776]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-784],  rdx
       mov  rax,  qword [rbp-784]
       imul  rax,  7
       mov  qword [rbp-792],  rax
       mov  rax,  qword [rbp-792]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-800],  rdx
       mov  rax,  qword [rbp-800]
       imul  rax,  7
       mov  qword [rbp-808],  rax
       mov  rax,  qword [rbp-808]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-816],  rdx
       mov  rax,  qword [rbp-816]
       imul  rax,  7
       mov  qword [rbp-824],  rax
       mov  rax,  qword [rbp-824]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-832],  rdx
       mov  rax,  qword [rbp-832]
       imul  rax,  7
       mov  qword [rbp-840],  rax
       mov  rax,  qword [rbp-840]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-848],  rdx
       mov  rax,  qword [rbp-848]
       imul  rax,  7
       mov  qword [rbp-856],  rax
       mov  rax,  qword [rbp-856]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-864],  rdx
       mov  rax,  qword [rbp-864]
       imul  rax,  7
       mov  qword [rbp-872],  rax
       mov  rax,  qword [rbp-872]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-880],  rdx
       mov  rax,  qword [rbp-880]
       imul  rax,  7
       mov  qword [rbp-888],  rax
       mov  rax,  qword [rbp-888]
       mov  rdx,  rax
       mov  rcx,  233
       mov  rdx,  0
       idiv  rcx
       mov  qword [rbp-896],  rdx
       mov  rax,  qword [rbp-896]
       mov  qword [rbp-24],  rax
       mov  rax,  qword [rbp-24]
       add  rsp,  992
       pop  rbp
       ret  
       jmp  label2
label1:
       jmp  label2
label2:
       mov  qword [rbp-904],  0
       mov  qword [rbp-912],  2
label8:
       mov  rcx,  qword [rbp-912]
       mov  rdx,  qword [rbp-8]
       cmp  rcx,  rdx
       jg  label11
label10:
       mov  qword [rbp-920],  1
       jmp  label12
label11:
       mov  qword [rbp-920],  0
label12:
       mov  rcx,  qword [rbp-920]
       cmp  rcx,  0
       jz  label7
label6:
       mov  rax,  qword [rbp-8]
       mov  rdx,  qword [rbp-912]
       xor  rax,  rdx
       mov  qword [rbp-928],  rax
       mov  rcx,  qword [rbp-928]
       mov  rdx,  qword [rbp-8]
       cmp  rcx,  rdx
       jge  label17
label16:
       mov  qword [rbp-936],  1
       jmp  label18
label17:
       mov  qword [rbp-936],  0
label18:
       mov  rcx,  qword [rbp-936]
       cmp  rcx,  0
       jz  label14
label13:
       mov  rax,  qword [rbp-8]
       mov  rdx,  qword [rbp-912]
       xor  rax,  rdx
       mov  qword [rbp-960],  rax
       mov  rax,  qword [rbp-960]
       mov  rdi,  rax
       call  dp
       mov  qword [rbp-952],  rax
       mov  rax,  qword [rbp-904]
       mov  rdi,  rax
       mov  rax,  qword [rbp-952]
       mov  rsi,  rax
       call  add
       mov  qword [rbp-944],  rax
       mov  rax,  qword [rbp-944]
       mov  qword [rbp-904],  rax
       jmp  label15
label14:
       jmp  label15
label15:
label9:
       mov  rax,  qword [rbp-912]
       mov  qword [rbp-968],  rax
       mov  rax,  qword [rbp-912]
       add  rax,  1
       mov  qword [rbp-912],  rax
       jmp  label8
label7:
       mov  rax,  qword [rbp-904]
       add  rsp,  992
       pop  rbp
       ret  
       add  rsp,  992
       pop  rbp
       ret  
main:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  80
       call  getInt
       mov  qword [rbp-24],  rax
       mov  rax,  qword [rbp-24]
       mov  qword [rbp-16],  rax
       mov  qword [rbp-8],  1
label21:
       mov  rcx,  qword [rbp-8]
       mov  rdx,  qword [rbp-16]
       cmp  rcx,  rdx
       jg  label24
label23:
       mov  qword [rbp-32],  1
       jmp  label25
label24:
       mov  qword [rbp-32],  0
label25:
       mov  rcx,  qword [rbp-32]
       cmp  rcx,  0
       jz  label20
label19:
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       call  dp
       mov  qword [rbp-48],  rax
       mov  rax,  qword [rbp-48]
       mov  rdi,  rax
       call  toString
       mov  qword [rbp-40],  rax
       mov  rax,  qword [rbp-40]
       mov  rdi,  rax
       call  println
label22:
       mov  rax,  qword [rbp-8]
       mov  qword [rbp-56],  rax
       mov  rax,  qword [rbp-8]
       add  rax,  1
       mov  qword [rbp-8],  rax
       jmp  label21
label20:
       mov  rax,  0
       add  rsp,  80
       pop  rbp
       ret  
       add  rsp,  80
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
