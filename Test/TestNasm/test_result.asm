global    origin
global    M
global    b
global    tmp
global    N
global    gps
global    getPrime
global    prime
global    result
global    i
global    printF
global    primeCount
global    resultCount
global    j
global    getResult
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

origin:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  80
       mov  qword [rbp-8],  rdi
       mov  rbx,  qword [rbp-8]
       mov  r15,  rbx
       add  r15,  1
       imul  r15,  8
       mov  rdi,  r15
       call  malloc
       mov  qword [rbp-16],  rax
       mov  rbx,  qword [rbp-8]
       mov  rax,  qword [rbp-16]
       mov  qword [rax + 0],  rbx
       mov  qword [rbp-24],  0
       mov  rax,  qword [rbp-16]
       mov  qword[result],  rax
       mov  qword[i],  0
label4:
       mov  rbx,  qword[i]
       mov  r10,  qword [rbp-8]
       cmp  rbx,  r10
       jge  label7
label6:
       mov  qword [rbp-32],  1
       jmp  label8
label7:
       mov  qword [rbp-32],  0
label8:
       mov  rbx,  qword [rbp-32]
       cmp  rbx,  0
       jz  label3
label2:
       mov  rbx,  qword [rbp-8]
       mov  r15,  rbx
       add  r15,  1
       imul  r15,  8
       mov  rdi,  r15
       call  malloc
       mov  qword [rbp-40],  rax
       mov  rbx,  qword [rbp-8]
       mov  rax,  qword [rbp-40]
       mov  qword [rax + 0],  rbx
       mov  r10,  qword [rbp-40]
       mov  rax,  qword[result]
       mov  rbx,  qword[i]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r10
       mov  qword[j],  0
label11:
       mov  rbx,  qword[j]
       mov  r10,  qword [rbp-8]
       cmp  rbx,  r10
       jge  label14
label13:
       mov  qword [rbp-48],  1
       jmp  label15
label14:
       mov  qword [rbp-48],  0
label15:
       mov  rbx,  qword [rbp-48]
       cmp  rbx,  0
       jz  label10
label9:
       mov  r10,  qword[result]
       mov  r11,  qword[i]
       add  r11,  1
       mov  rax,  qword [r10 + r11 * 8]
       mov  rbx,  qword[j]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  0
label12:
       mov  rax,  qword[j]
       mov  qword [rbp-56],  rax
       mov  rax,  qword[j]
       add  rax,  1
       mov  qword[j],  rax
       jmp  label11
label10:
label5:
       mov  rax,  qword[i]
       mov  qword [rbp-64],  rax
       mov  rax,  qword[i]
       add  rax,  1
       mov  qword[i],  rax
       jmp  label4
label3:
       add  rsp,  80
       pop  rbp
       ret  
       add  rsp,  80
       pop  rbp
       ret  
getPrime:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  112
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  2
       mov  qword [rbp-24],  2
label18:
       mov  rbx,  qword [rbp-24]
       mov  r10,  qword [rbp-8]
       cmp  rbx,  r10
       jg  label21
label20:
       mov  qword [rbp-32],  1
       jmp  label22
label21:
       mov  qword [rbp-32],  0
label22:
       mov  rbx,  qword [rbp-32]
       cmp  rbx,  0
       jz  label17
label16:
       mov  rbx,  qword[b]
       mov  r10,  qword [rbp-24]
       add  r10,  1
       mov  r11,  qword [rbx + r10 * 8]
       cmp  r11,  1
       jne  label27
label26:
       mov  qword [rbp-40],  1
       jmp  label28
label27:
       mov  qword [rbp-40],  0
label28:
       mov  rbx,  qword [rbp-40]
       cmp  rbx,  0
       jz  label24
label23:
       mov  rbx,  qword[tmp]
       mov  rax,  qword [rbx + 8]
       add  rax,  1
       mov  qword [rbp-48],  rax
       mov  rbx,  qword [rbp-48]
       mov  rax,  qword[tmp]
       mov  qword [rax + 8],  rbx
       mov  r11,  qword [rbp-24]
       mov  rax,  qword[prime]
       mov  r10,  qword[tmp]
       mov  rbx,  qword [r10 + 8]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r11
       mov  r10,  qword[tmp]
       mov  r11,  qword [r10 + 8]
       mov  rax,  qword[gps]
       mov  rbx,  qword [rbp-24]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r11
       jmp  label25
label24:
       jmp  label25
label25:
label31:
       mov  rax,  qword [rbp-24]
       mov  r10,  qword [rbp-16]
       imul  rax,  r10
       mov  qword [rbp-56],  rax
       mov  rbx,  qword [rbp-56]
       mov  r10,  qword [rbp-8]
       cmp  rbx,  r10
       jg  label33
label32:
       mov  qword [rbp-64],  1
       jmp  label34
label33:
       mov  qword [rbp-64],  0
label34:
       mov  rbx,  qword [rbp-64]
       cmp  rbx,  0
       jz  label30
label29:
       mov  rax,  qword [rbp-24]
       mov  r10,  qword [rbp-16]
       imul  rax,  r10
       mov  qword [rbp-72],  rax
       mov  rax,  qword[b]
       mov  rbx,  qword [rbp-72]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  0
       mov  rax,  qword [rbp-16]
       add  rax,  1
       mov  qword [rbp-80],  rax
       mov  rax,  qword [rbp-80]
       mov  qword [rbp-16],  rax
       jmp  label31
label30:
       mov  qword [rbp-16],  2
label19:
       mov  rax,  qword [rbp-24]
       add  rax,  1
       mov  qword [rbp-88],  rax
       mov  rax,  qword [rbp-88]
       mov  qword [rbp-24],  rax
       jmp  label18
label17:
       add  rsp,  112
       pop  rbp
       ret  
getResult:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  160
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  qword [rbp-24],  rdx
       mov  rax,  1
       neg  rax
       mov  qword [rbp-32],  rax
       mov  r11,  qword[result]
       mov  r12,  qword [rbp-16]
       add  r12,  1
       mov  rbx,  qword [r11 + r12 * 8]
       mov  r10,  qword [rbp-24]
       add  r10,  1
       mov  r13,  qword [rbx + r10 * 8]
       mov  r14,  qword [rbp-32]
       cmp  r13,  r14
       jne  label39
label38:
       mov  qword [rbp-40],  1
       jmp  label40
label39:
       mov  qword [rbp-40],  0
label40:
       mov  rbx,  qword [rbp-40]
       cmp  rbx,  0
       jz  label36
label35:
       mov  rbx,  qword[prime]
       mov  r10,  qword [rbp-24]
       add  r10,  1
       mov  rax,  qword [rbx + r10 * 8]
       imul  rax,  2
       mov  qword [rbp-48],  rax
       mov  rax,  qword [rbp-48]
       mov  r10,  qword[prime]
       mov  r11,  qword [rbp-16]
       add  r11,  1
       mov  r12,  qword [r10 + r11 * 8]
       sub  rax,  r12
       mov  qword [rbp-56],  rax
       mov  rbx,  qword [rbp-56]
       mov  r10,  qword [rbp-8]
       cmp  rbx,  r10
       jg  label45
label44:
       mov  qword [rbp-64],  1
       jmp  label46
label45:
       mov  qword [rbp-64],  0
label46:
       mov  rbx,  qword [rbp-64]
       cmp  rbx,  0
       jz  label42
label41:
       mov  rbx,  qword[prime]
       mov  r10,  qword [rbp-24]
       add  r10,  1
       mov  rax,  qword [rbx + r10 * 8]
       imul  rax,  2
       mov  qword [rbp-72],  rax
       mov  rax,  qword [rbp-72]
       mov  r10,  qword[prime]
       mov  r11,  qword [rbp-16]
       add  r11,  1
       mov  r12,  qword [r10 + r11 * 8]
       sub  rax,  r12
       mov  qword [rbp-80],  rax
       mov  rbx,  qword[b]
       mov  r10,  qword [rbp-80]
       add  r10,  1
       mov  r11,  qword [rbx + r10 * 8]
       cmp  r11,  0
       je  label51
label50:
       mov  qword [rbp-88],  1
       jmp  label52
label51:
       mov  qword [rbp-88],  0
label52:
       mov  rbx,  qword [rbp-88]
       cmp  rbx,  0
       jz  label48
label47:
       mov  rbx,  qword[prime]
       mov  r10,  qword [rbp-24]
       add  r10,  1
       mov  rax,  qword [rbx + r10 * 8]
       imul  rax,  2
       mov  qword [rbp-104],  rax
       mov  rax,  qword [rbp-104]
       mov  r10,  qword[prime]
       mov  r11,  qword [rbp-16]
       add  r11,  1
       mov  r12,  qword [r10 + r11 * 8]
       sub  rax,  r12
       mov  qword [rbp-112],  rax
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       mov  rax,  qword[gps]
       mov  rbx,  qword [rbp-112]
       add  rbx,  1
       mov  rax,  qword [rax + rbx * 8]
       mov  rdx,  rax
       call  getResult
       mov  qword [rbp-96],  rax
       mov  rax,  qword [rbp-96]
       add  rax,  1
       mov  qword [rbp-120],  rax
       mov  r12,  qword [rbp-120]
       mov  r10,  qword[result]
       mov  r11,  qword [rbp-16]
       add  r11,  1
       mov  rax,  qword [r10 + r11 * 8]
       mov  rbx,  qword [rbp-24]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r12
       jmp  label49
label48:
       jmp  label49
label49:
       jmp  label43
label42:
       jmp  label43
label43:
       jmp  label37
label36:
       jmp  label37
label37:
       mov  rax,  1
       neg  rax
       mov  qword [rbp-128],  rax
       mov  r11,  qword[result]
       mov  r12,  qword [rbp-16]
       add  r12,  1
       mov  rbx,  qword [r11 + r12 * 8]
       mov  r10,  qword [rbp-24]
       add  r10,  1
       mov  r13,  qword [rbx + r10 * 8]
       mov  r14,  qword [rbp-128]
       cmp  r13,  r14
       jne  label57
label56:
       mov  qword [rbp-136],  1
       jmp  label58
label57:
       mov  qword [rbp-136],  0
label58:
       mov  rbx,  qword [rbp-136]
       cmp  rbx,  0
       jz  label54
label53:
       mov  r10,  qword[result]
       mov  r11,  qword [rbp-16]
       add  r11,  1
       mov  rax,  qword [r10 + r11 * 8]
       mov  rbx,  qword [rbp-24]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  1
       jmp  label55
label54:
       jmp  label55
label55:
       mov  r10,  qword[result]
       mov  r11,  qword [rbp-16]
       add  r11,  1
       mov  rax,  qword [r10 + r11 * 8]
       mov  rbx,  qword [rbp-24]
       add  rbx,  1
       mov  r12,  qword [rax + rbx * 8]
       mov  rax,  r12
       add  rsp,  160
       pop  rbp
       ret  
       add  rsp,  160
       pop  rbp
       ret  
printF:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  112
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  qword [rbp-24],  rdx
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       call  toString
       mov  qword [rbp-32],  rax
       mov  rax,  qword [rbp-32]
       mov  rdi,  rax
       call  print
label61:
       mov  rbx,  qword [rbp-24]
       cmp  rbx,  0
       jle  label63
label62:
       mov  qword [rbp-40],  1
       jmp  label64
label63:
       mov  qword [rbp-40],  0
label64:
       mov  rbx,  qword [rbp-40]
       cmp  rbx,  0
       jz  label60
label59:
       mov  rax,  String_0
       mov  qword [rbp-48],  rax
       mov  rax,  qword [rbp-48]
       mov  rdi,  rax
       call  print
       mov  rax,  qword [rbp-16]
       mov  rdi,  rax
       call  toString
       mov  qword [rbp-56],  rax
       mov  rax,  qword [rbp-56]
       mov  rdi,  rax
       call  print
       mov  rax,  qword [rbp-16]
       imul  rax,  2
       mov  qword [rbp-64],  rax
       mov  rax,  qword [rbp-64]
       mov  r10,  qword [rbp-8]
       sub  rax,  r10
       mov  qword [rbp-72],  rax
       mov  rax,  qword [rbp-72]
       mov  qword [rbp-16],  rax
       mov  rax,  qword [rbp-8]
       mov  r10,  qword [rbp-16]
       add  rax,  r10
       mov  qword [rbp-80],  rax
       mov  rax,  qword [rbp-80]
       mov  rbx,  2
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-88],  rax
       mov  rax,  qword [rbp-88]
       mov  qword [rbp-8],  rax
       mov  rax,  qword [rbp-24]
       sub  rax,  1
       mov  qword [rbp-96],  rax
       mov  rax,  qword [rbp-96]
       mov  qword [rbp-24],  rax
       jmp  label61
label60:
       mov  rax,  String_1
       mov  qword [rbp-104],  rax
       mov  rax,  qword [rbp-104]
       mov  rdi,  rax
       call  print
       add  rsp,  112
       pop  rbp
       ret  
main:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  224
       mov  rdi,  8016
       call  malloc
       mov  qword [rbp-8],  rax
       mov  rax,  qword [rbp-8]
       mov  qword [rax + 0],  1001
       mov  rax,  qword [rbp-8]
       mov  qword[b],  rax
       mov  rdi,  1368
       call  malloc
       mov  qword [rbp-16],  rax
       mov  rax,  qword [rbp-16]
       mov  qword [rax + 0],  170
       mov  rax,  qword [rbp-16]
       mov  qword[prime],  rax
       mov  rdi,  8016
       call  malloc
       mov  qword [rbp-24],  rax
       mov  rax,  qword [rbp-24]
       mov  qword [rax + 0],  1001
       mov  rax,  qword [rbp-24]
       mov  qword[gps],  rax
       mov  rdi,  16
       call  malloc
       mov  qword [rbp-32],  rax
       mov  rax,  qword [rbp-32]
       mov  qword [rax + 0],  1
       mov  rax,  qword [rbp-32]
       mov  qword[tmp],  rax
       mov  rdi,  170
       call  origin
       mov  qword[N],  1000
       call  getInt
       mov  qword [rbp-8],  rax
       mov  rax,  qword [rbp-8]
       mov  qword[M],  rax
       mov  qword[primeCount],  0
       mov  qword[resultCount],  0
       mov  rax,  qword[tmp]
       mov  qword [rax + 8],  0
       mov  qword[i],  0
label67:
       mov  rax,  qword[N]
       add  rax,  1
       mov  qword [rbp-16],  rax
       mov  rbx,  qword[i]
       mov  r10,  qword [rbp-16]
       cmp  rbx,  r10
       jge  label70
label69:
       mov  qword [rbp-24],  1
       jmp  label71
label70:
       mov  qword [rbp-24],  0
label71:
       mov  rbx,  qword [rbp-24]
       cmp  rbx,  0
       jz  label66
label65:
       mov  rax,  qword[b]
       mov  rbx,  qword[i]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  1
       mov  rax,  qword[gps]
       mov  rbx,  qword[i]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  0
label68:
       mov  rax,  qword[i]
       add  rax,  1
       mov  qword [rbp-32],  rax
       mov  rax,  qword [rbp-32]
       mov  qword[i],  rax
       jmp  label67
label66:
       mov  qword[i],  0
label74:
       mov  rax,  qword[M]
       add  rax,  1
       mov  qword [rbp-40],  rax
       mov  rbx,  qword[i]
       mov  r10,  qword [rbp-40]
       cmp  rbx,  r10
       jge  label77
label76:
       mov  qword [rbp-48],  1
       jmp  label78
label77:
       mov  qword [rbp-48],  0
label78:
       mov  rbx,  qword [rbp-48]
       cmp  rbx,  0
       jz  label73
label72:
       mov  rax,  qword[prime]
       mov  rbx,  qword[i]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  0
label75:
       mov  rax,  qword[i]
       add  rax,  1
       mov  qword [rbp-56],  rax
       mov  rax,  qword [rbp-56]
       mov  qword[i],  rax
       jmp  label74
label73:
       mov  qword[i],  0
label81:
       mov  rbx,  qword[i]
       mov  r10,  qword[M]
       cmp  rbx,  r10
       jg  label84
label83:
       mov  qword [rbp-64],  1
       jmp  label85
label84:
       mov  qword [rbp-64],  0
label85:
       mov  rbx,  qword [rbp-64]
       cmp  rbx,  0
       jz  label80
label79:
       mov  qword[j],  0
label88:
       mov  rbx,  qword[j]
       mov  r10,  qword[M]
       cmp  rbx,  r10
       jg  label91
label90:
       mov  qword [rbp-72],  1
       jmp  label92
label91:
       mov  qword [rbp-72],  0
label92:
       mov  rbx,  qword [rbp-72]
       cmp  rbx,  0
       jz  label87
label86:
       mov  rax,  1
       neg  rax
       mov  qword [rbp-80],  rax
       mov  r12,  qword [rbp-80]
       mov  r10,  qword[result]
       mov  r11,  qword[i]
       add  r11,  1
       mov  rax,  qword [r10 + r11 * 8]
       mov  rbx,  qword[j]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r12
label89:
       mov  rax,  qword[j]
       add  rax,  1
       mov  qword [rbp-88],  rax
       mov  rax,  qword [rbp-88]
       mov  qword[j],  rax
       jmp  label88
label87:
label82:
       mov  rax,  qword[i]
       add  rax,  1
       mov  qword [rbp-96],  rax
       mov  rax,  qword [rbp-96]
       mov  qword[i],  rax
       jmp  label81
label80:
       mov  rax,  qword[N]
       mov  rdi,  rax
       call  getPrime
       mov  qword [rbp-104],  rax
       mov  rax,  qword[tmp]
       mov  rbx,  qword [rax + 8]
       mov  qword[primeCount],  rbx
       mov  qword[i],  1
label95:
       mov  rbx,  qword[i]
       mov  r10,  qword[primeCount]
       cmp  rbx,  r10
       jge  label98
label97:
       mov  qword [rbp-112],  1
       jmp  label99
label98:
       mov  qword [rbp-112],  0
label99:
       mov  rbx,  qword [rbp-112]
       cmp  rbx,  0
       jz  label94
label93:
       mov  rax,  qword[i]
       add  rax,  1
       mov  qword [rbp-120],  rax
       mov  rax,  qword [rbp-120]
       mov  qword[j],  rax
label102:
       mov  rbx,  qword[j]
       mov  r10,  qword[primeCount]
       cmp  rbx,  r10
       jg  label105
label104:
       mov  qword [rbp-128],  1
       jmp  label106
label105:
       mov  qword [rbp-128],  0
label106:
       mov  rbx,  qword [rbp-128]
       cmp  rbx,  0
       jz  label101
label100:
       mov  rax,  1
       neg  rax
       mov  qword [rbp-136],  rax
       mov  r11,  qword[result]
       mov  r12,  qword[i]
       add  r12,  1
       mov  rbx,  qword [r11 + r12 * 8]
       mov  r10,  qword[j]
       add  r10,  1
       mov  r13,  qword [rbx + r10 * 8]
       mov  r14,  qword [rbp-136]
       cmp  r13,  r14
       jne  label111
label110:
       mov  qword [rbp-144],  1
       jmp  label112
label111:
       mov  qword [rbp-144],  0
label112:
       mov  rbx,  qword [rbp-144]
       cmp  rbx,  0
       jz  label108
label107:
       mov  rax,  qword[N]
       mov  rdi,  rax
       mov  rax,  qword[i]
       mov  rsi,  rax
       mov  rax,  qword[j]
       mov  rdx,  rax
       call  getResult
       mov  qword [rbp-152],  rax
       mov  r12,  qword [rbp-152]
       mov  r10,  qword[result]
       mov  r11,  qword[i]
       add  r11,  1
       mov  rax,  qword [r10 + r11 * 8]
       mov  rbx,  qword[j]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r12
       mov  r11,  qword[result]
       mov  r12,  qword[i]
       add  r12,  1
       mov  rbx,  qword [r11 + r12 * 8]
       mov  r10,  qword[j]
       add  r10,  1
       mov  r13,  qword [rbx + r10 * 8]
       cmp  r13,  1
       jle  label117
label116:
       mov  qword [rbp-160],  1
       jmp  label118
label117:
       mov  qword [rbp-160],  0
label118:
       mov  rbx,  qword [rbp-160]
       cmp  rbx,  0
       jz  label114
label113:
       mov  rax,  qword[prime]
       mov  rbx,  qword[i]
       add  rbx,  1
       mov  rax,  qword [rax + rbx * 8]
       mov  rdi,  rax
       mov  r10,  qword[prime]
       mov  r11,  qword[j]
       add  r11,  1
       mov  rax,  qword [r10 + r11 * 8]
       mov  rsi,  rax
       mov  r14,  qword[result]
       mov  r15,  qword[i]
       add  r15,  1
       mov  r12,  qword [r14 + r15 * 8]
       mov  r13,  qword[j]
       add  r13,  1
       mov  rax,  qword [r12 + r13 * 8]
       mov  rdx,  rax
       call  printF
       mov  qword [rbp-168],  rax
       mov  rax,  qword[resultCount]
       add  rax,  1
       mov  qword [rbp-176],  rax
       mov  rax,  qword [rbp-176]
       mov  qword[resultCount],  rax
       jmp  label115
label114:
       jmp  label115
label115:
       jmp  label109
label108:
       jmp  label109
label109:
label103:
       mov  rax,  qword[j]
       add  rax,  1
       mov  qword [rbp-184],  rax
       mov  rax,  qword [rbp-184]
       mov  qword[j],  rax
       jmp  label102
label101:
label96:
       mov  rax,  qword[i]
       add  rax,  1
       mov  qword [rbp-192],  rax
       mov  rax,  qword [rbp-192]
       mov  qword[i],  rax
       jmp  label95
label94:
       mov  rax,  String_2
       mov  qword [rbp-200],  rax
       mov  rax,  qword [rbp-200]
       mov  rdi,  rax
       call  print
       mov  rax,  qword[resultCount]
       mov  rdi,  rax
       call  toString
       mov  qword [rbp-208],  rax
       mov  rax,  qword [rbp-208]
       mov  rdi,  rax
       call  println
       mov  rax,  0
       add  rsp,  224
       pop  rbp
       ret  
       add  rsp,  224
       pop  rbp
       ret  

section .data
       dq  1
String_0:
       db  32, 0
       dq  1
String_1:
       db  10, 0
       dq  7
String_2:
       db  84, 111, 116, 97, 108, 58, 32, 0

section .bss

N:       resq  1
M:       resq  1
i:       resq  1
j:       resq  1
primeCount:       resq  1
resultCount:       resq  1
b:       resq  1
prime:       resq  1
gps:       resq  1
tmp:       resq  1
result:       resq  1


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
