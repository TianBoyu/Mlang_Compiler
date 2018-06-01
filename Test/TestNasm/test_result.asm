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

main:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  768
       mov  rax,  String_0
       mov  qword [rbp-16],  rax
       mov  rax,  qword [rbp-16]
       mov  qword [rbp-8],  rax
       mov  rax,  String_1
       mov  qword [rbp-32],  rax
       mov  rax,  qword [rbp-32]
       mov  qword [rbp-24],  rax
       mov  rax,  String_2
       mov  qword [rbp-48],  rax
       mov  rax,  qword [rbp-48]
       mov  qword [rbp-40],  rax
       mov  rax,  qword [rbp-40]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-120],  rax
       mov  rax,  qword [rbp-120]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-112],  rax
       mov  rax,  qword [rbp-112]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-104],  rax
       mov  rax,  qword [rbp-104]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-96],  rax
       mov  rax,  qword [rbp-96]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-88],  rax
       mov  rax,  qword [rbp-88]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-80],  rax
       mov  rax,  qword [rbp-80]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-72],  rax
       mov  rax,  qword [rbp-72]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-64],  rax
       mov  rax,  qword [rbp-64]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-56],  rax
       mov  rax,  qword [rbp-56]
       mov  rdi,  rax
       call  print
       mov  rax,  qword [rbp-40]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-192],  rax
       mov  rax,  qword [rbp-192]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-184],  rax
       mov  rax,  qword [rbp-184]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-176],  rax
       mov  rax,  qword [rbp-176]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-168],  rax
       mov  rax,  qword [rbp-168]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-160],  rax
       mov  rax,  qword [rbp-160]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-152],  rax
       mov  rax,  qword [rbp-152]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-144],  rax
       mov  rax,  qword [rbp-144]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-136],  rax
       mov  rax,  qword [rbp-136]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-128],  rax
       mov  rax,  qword [rbp-128]
       mov  rdi,  rax
       call  print
       mov  rax,  qword [rbp-24]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-264],  rax
       mov  rax,  qword [rbp-264]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-256],  rax
       mov  rax,  qword [rbp-256]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-248],  rax
       mov  rax,  qword [rbp-248]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-240],  rax
       mov  rax,  qword [rbp-240]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-232],  rax
       mov  rax,  qword [rbp-232]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-224],  rax
       mov  rax,  qword [rbp-224]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-216],  rax
       mov  rax,  qword [rbp-216]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-208],  rax
       mov  rax,  qword [rbp-208]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-200],  rax
       mov  rax,  qword [rbp-200]
       mov  rdi,  rax
       call  print
       mov  rax,  qword [rbp-24]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-336],  rax
       mov  rax,  qword [rbp-336]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-328],  rax
       mov  rax,  qword [rbp-328]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-320],  rax
       mov  rax,  qword [rbp-320]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-312],  rax
       mov  rax,  qword [rbp-312]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-304],  rax
       mov  rax,  qword [rbp-304]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-296],  rax
       mov  rax,  qword [rbp-296]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-288],  rax
       mov  rax,  qword [rbp-288]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-280],  rax
       mov  rax,  qword [rbp-280]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-272],  rax
       mov  rax,  qword [rbp-272]
       mov  rdi,  rax
       call  print
       mov  rax,  qword [rbp-24]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-408],  rax
       mov  rax,  qword [rbp-408]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-400],  rax
       mov  rax,  qword [rbp-400]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-392],  rax
       mov  rax,  qword [rbp-392]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-384],  rax
       mov  rax,  qword [rbp-384]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-376],  rax
       mov  rax,  qword [rbp-376]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-368],  rax
       mov  rax,  qword [rbp-368]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-360],  rax
       mov  rax,  qword [rbp-360]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-352],  rax
       mov  rax,  qword [rbp-352]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-344],  rax
       mov  rax,  qword [rbp-344]
       mov  rdi,  rax
       call  print
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-480],  rax
       mov  rax,  qword [rbp-480]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-472],  rax
       mov  rax,  qword [rbp-472]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-464],  rax
       mov  rax,  qword [rbp-464]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-456],  rax
       mov  rax,  qword [rbp-456]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-448],  rax
       mov  rax,  qword [rbp-448]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-440],  rax
       mov  rax,  qword [rbp-440]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-432],  rax
       mov  rax,  qword [rbp-432]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-424],  rax
       mov  rax,  qword [rbp-424]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-416],  rax
       mov  rax,  qword [rbp-416]
       mov  rdi,  rax
       call  print
       mov  rax,  qword [rbp-24]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-552],  rax
       mov  rax,  qword [rbp-552]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-544],  rax
       mov  rax,  qword [rbp-544]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-536],  rax
       mov  rax,  qword [rbp-536]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-528],  rax
       mov  rax,  qword [rbp-528]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-520],  rax
       mov  rax,  qword [rbp-520]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-512],  rax
       mov  rax,  qword [rbp-512]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-504],  rax
       mov  rax,  qword [rbp-504]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-496],  rax
       mov  rax,  qword [rbp-496]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-488],  rax
       mov  rax,  qword [rbp-488]
       mov  rdi,  rax
       call  print
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-624],  rax
       mov  rax,  qword [rbp-624]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-616],  rax
       mov  rax,  qword [rbp-616]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-608],  rax
       mov  rax,  qword [rbp-608]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-600],  rax
       mov  rax,  qword [rbp-600]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-592],  rax
       mov  rax,  qword [rbp-592]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-584],  rax
       mov  rax,  qword [rbp-584]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-576],  rax
       mov  rax,  qword [rbp-576]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-568],  rax
       mov  rax,  qword [rbp-568]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-560],  rax
       mov  rax,  qword [rbp-560]
       mov  rdi,  rax
       call  print
       mov  rax,  qword [rbp-40]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-696],  rax
       mov  rax,  qword [rbp-696]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-688],  rax
       mov  rax,  qword [rbp-688]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-680],  rax
       mov  rax,  qword [rbp-680]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-672],  rax
       mov  rax,  qword [rbp-672]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-664],  rax
       mov  rax,  qword [rbp-664]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-656],  rax
       mov  rax,  qword [rbp-656]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-648],  rax
       mov  rax,  qword [rbp-648]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-640],  rax
       mov  rax,  qword [rbp-640]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-632],  rax
       mov  rax,  qword [rbp-632]
       mov  rdi,  rax
       call  print
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-768],  rax
       mov  rax,  qword [rbp-768]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-760],  rax
       mov  rax,  qword [rbp-760]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-752],  rax
       mov  rax,  qword [rbp-752]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-744],  rax
       mov  rax,  qword [rbp-744]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-736],  rax
       mov  rax,  qword [rbp-736]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-728],  rax
       mov  rax,  qword [rbp-728]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-720],  rax
       mov  rax,  qword [rbp-720]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-712],  rax
       mov  rax,  qword [rbp-712]
       mov  rdi,  rax
       mov  rax,  qword [rbp-40]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-704],  rax
       mov  rax,  qword [rbp-704]
       mov  rdi,  rax
       call  print
       mov  rax,  0
       add  rsp,  768
       pop  rbp
       ret  
       add  rsp,  768
       pop  rbp
       ret  

section .data
       dq  20
String_0:
       db  34, 10, 98, 100, 97, 92, 34, 10, 100, 98, 100, 92, 99, 34, 92, 34, 99, 92, 99, 34, 0
       dq  20
String_1:
       db  92, 97, 98, 10, 97, 99, 34, 34, 97, 100, 100, 10, 34, 10, 97, 99, 10, 100, 98, 34, 0
       dq  20
String_2:
       db  10, 97, 98, 98, 100, 98, 100, 100, 92, 92, 34, 100, 34, 99, 92, 97, 100, 99, 34, 99, 0

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
