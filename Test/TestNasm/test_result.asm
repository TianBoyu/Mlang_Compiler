global    M
global    now
global    show
global    random
global    swap
global    h
global    initialize
global    main
global    win
global    pd
global    R
global    merge
global    seed
global    A
global    a
global    n
global    Q
global    move


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

random:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  80
       mov  r15,  qword[seed]
       mov  rbx,  r15
       mov  r14,  qword[Q]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r14
       mov  rbx,  rdx
       mov  r13,  qword[A]
       mov  r10,  r13
       mov  r10,  r10
       imul  r10,  rbx
       mov  r10,  r10
       mov  r15,  qword[seed]
       mov  rbx,  r15
       mov  r14,  qword[Q]
       mov  rax,  rbx
       mov  rdx,  0
       idiv  r14
       mov  rbx,  rax
       mov  r13,  qword[R]
       mov  r11,  r13
       mov  r11,  r11
       imul  r11,  rbx
       mov  r11,  r11
       mov  rbx,  r10
       mov  rbx,  rbx
       sub  rbx,  r11
       mov  rbx,  rbx
       mov  r10,  rbx
       cmp  r10,  0
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
       mov  qword[seed],  r10
       jmp  label2
label1:
       mov  rbx,  r10
       mov  r15,  qword[M]
       mov  rbx,  rbx
       add  rbx,  r15
       mov  rbx,  rbx
       mov  qword[seed],  rbx
       jmp  label2
label2:
       mov  rax,  qword[seed]
       add  rsp,  80
       pop  rbp
       ret  
       add  rsp,  80
       pop  rbp
       ret  
initialize:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  32
       mov  rbx,  rdi
       mov  qword[seed],  rbx
       add  rsp,  32
       pop  rbp
       ret  
       add  rsp,  32
       pop  rbp
       ret  
swap:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  80
       mov  qword [rbp-8],  rdi
       mov  r11,  rsi
       mov  r14,  qword[a]
       mov  rbx,  r14
       mov  r13,  qword [rbp-8]
       mov  r15,  r13
       add  r15,  1
       mov  r14,  qword [rbx + r15 * 8]
       mov  rbx,  r14
       mov  r13,  qword[a]
       mov  r10,  r13
       mov  r15,  qword[a]
       mov  r12,  r15
       mov  r14,  r11
       add  r14,  1
       mov  r13,  qword [r12 + r14 * 8]
       mov  r15,  qword [rbp-8]
       mov  r14,  r15
       add  r14,  1
       mov  qword [r10 + r14 * 8],  r13
       mov  r13,  qword[a]
       mov  r10,  r13
       mov  r15,  r11
       add  r15,  1
       mov  qword [r10 + r15 * 8],  rbx
       add  rsp,  80
       pop  rbp
       ret  
       add  rsp,  80
       pop  rbp
       ret  
pd:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  64
       mov  r10,  rdi
       jmp  label8
label8:
       mov  r14,  qword[h]
       cmp  r14,  r10
       jg  label11
label10:
       mov  rbx,  1
       jmp  label12
label11:
       mov  rbx,  0
       jmp  label12
label12:
       cmp  rbx,  0
       jz  label7
label6:
       mov  r13,  qword[h]
       mov  r11,  r13
       mov  r11,  r11
       add  r11,  1
       mov  r11,  r11
       mov  r15,  qword[h]
       mov  rbx,  r15
       mov  rbx,  rbx
       imul  rbx,  r11
       mov  rbx,  rbx
       mov  rbx,  rbx
       mov  rax,  rbx
       mov  r14,  2
       mov  rdx,  0
       idiv  r14
       mov  rbx,  rax
       cmp  r10,  rbx
       jne  label17
label16:
       mov  rbx,  1
       jmp  label18
label17:
       mov  rbx,  0
       jmp  label18
label18:
       cmp  rbx,  0
       jz  label14
label13:
       mov  rax,  1
       add  rsp,  64
       pop  rbp
       ret  
       jmp  label15
label14:
       jmp  label15
label15:
       jmp  label9
label9:
       mov  r13,  qword[h]
       mov  r15,  qword[h]
       mov  r15,  r13
       add  r15,  1
       mov  qword[h],  r15
       jmp  label8
label7:
       mov  rax,  0
       add  rsp,  64
       pop  rbp
       ret  
       add  rsp,  64
       pop  rbp
       ret  
show:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  64
       mov  r11,  0
       jmp  label21
label21:
       mov  r14,  qword[now]
       cmp  r11,  r14
       jge  label24
label23:
       mov  r10,  1
       jmp  label25
label24:
       mov  r10,  0
       jmp  label25
label25:
       cmp  r10,  0
       jz  label20
label19:
       mov  r13,  qword[a]
       mov  r10,  r13
       push  r11
       push  r10
       push  rbp
       push  rbx
       mov  r15,  r11
       add  r15,  1
       mov  rdi,  qword [r10 + r15 * 8]
       call  toString
       pop  rbx
       pop  rbp
       pop  r10
       pop  r11
       mov  r10,  rax
       push  r11
       push  r10
       push  rbp
       push  rbx
       mov  rdi,  r10
       mov  rsi,  String_0
       call  Str_ADD
       pop  rbx
       pop  rbp
       pop  r10
       pop  r11
       mov  r10,  rax
       push  r11
       push  r10
       push  rbp
       push  rbx
       mov  rdi,  r10
       call  print
       pop  rbx
       pop  rbp
       pop  r10
       pop  r11
       jmp  label22
label22:
       mov  r11,  r11
       add  r11,  1
       mov  r11,  r11
       jmp  label21
label20:
       push  r11
       push  r10
       push  rbp
       push  rbx
       mov  rdi,  String_1
       call  println
       pop  rbx
       pop  rbp
       pop  r10
       pop  r11
       add  rsp,  64
       pop  rbp
       ret  
       add  rsp,  64
       pop  rbp
       ret  
win:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  208
       mov  rdi,  808
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       call  malloc
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       mov  rbx,  rax
       mov  qword [rbx + 0],  100
       mov  r10,  rbx
       mov  r14,  qword[now]
       mov  r13,  qword[h]
       cmp  r14,  r13
       je  label30
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
       mov  rax,  0
       add  rsp,  208
       pop  rbp
       ret  
       jmp  label28
label27:
       jmp  label28
label28:
       mov  qword [rbp-8],  0
       jmp  label34
label34:
       mov  r15,  qword [rbp-8]
       mov  r14,  qword[now]
       cmp  r15,  r14
       jge  label37
label36:
       mov  rbx,  1
       jmp  label38
label37:
       mov  rbx,  0
       jmp  label38
label38:
       cmp  rbx,  0
       jz  label33
label32:
       mov  r10,  r10
       mov  r13,  qword[a]
       mov  rbx,  r13
       mov  r15,  qword [rbp-8]
       mov  r14,  r15
       add  r14,  1
       mov  r13,  qword [rbx + r14 * 8]
       mov  r15,  qword [rbp-8]
       mov  r14,  r15
       add  r14,  1
       mov  qword [r10 + r14 * 8],  r13
       jmp  label35
label35:
       mov  r13,  qword [rbp-8]
       mov  r15,  qword [rbp-8]
       mov  r15,  r13
       add  r15,  1
       mov  qword [rbp-8],  r15
       jmp  label34
label33:
       mov  r11,  0
       jmp  label41
label41:
       mov  r14,  qword[now]
       mov  rbx,  r14
       mov  rbx,  rbx
       sub  rbx,  1
       mov  rbx,  rbx
       cmp  r11,  rbx
       jge  label44
label43:
       mov  rbx,  1
       jmp  label45
label44:
       mov  rbx,  0
       jmp  label45
label45:
       cmp  rbx,  0
       jz  label40
label39:
       mov  rbx,  r11
       mov  rbx,  rbx
       add  rbx,  1
       mov  rbx,  rbx
       mov  qword [rbp-8],  rbx
       jmp  label48
label48:
       mov  r13,  qword [rbp-8]
       mov  r15,  qword[now]
       cmp  r13,  r15
       jge  label51
label50:
       mov  rbx,  1
       jmp  label52
label51:
       mov  rbx,  0
       jmp  label52
label52:
       cmp  rbx,  0
       jz  label47
label46:
       mov  rbx,  r10
       mov  r10,  r10
       mov  r14,  r11
       add  r14,  1
       mov  r13,  qword [rbx + r14 * 8]
       mov  r15,  qword [rbp-8]
       mov  r14,  r15
       add  r14,  1
       mov  r13,  qword [r10 + r14 * 8]
       cmp  r13,  r13
       jle  label57
label56:
       mov  rbx,  1
       jmp  label58
label57:
       mov  rbx,  0
       jmp  label58
label58:
       cmp  rbx,  0
       jz  label54
label53:
       mov  rbx,  r10
       mov  r15,  r11
       add  r15,  1
       mov  r14,  qword [rbx + r15 * 8]
       mov  rbx,  r14
       mov  r10,  r10
       mov  r12,  r10
       mov  r13,  qword [rbp-8]
       mov  r15,  r13
       add  r15,  1
       mov  r14,  qword [r12 + r15 * 8]
       mov  r13,  r11
       add  r13,  1
       mov  qword [r10 + r13 * 8],  r14
       mov  r10,  r10
       mov  r15,  qword [rbp-8]
       mov  r14,  r15
       add  r14,  1
       mov  qword [r10 + r14 * 8],  rbx
       jmp  label55
label54:
       jmp  label55
label55:
       jmp  label49
label49:
       mov  r13,  qword [rbp-8]
       mov  r15,  qword [rbp-8]
       mov  r15,  r13
       add  r15,  1
       mov  qword [rbp-8],  r15
       jmp  label48
label47:
       jmp  label42
label42:
       mov  r11,  r11
       add  r11,  1
       mov  r11,  r11
       jmp  label41
label40:
       mov  r11,  0
       jmp  label61
label61:
       mov  r14,  qword[now]
       cmp  r11,  r14
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
       mov  r10,  r10
       mov  rbx,  r11
       mov  rbx,  rbx
       add  rbx,  1
       mov  rbx,  rbx
       mov  r13,  r11
       add  r13,  1
       mov  r15,  qword [r10 + r13 * 8]
       cmp  r15,  rbx
       je  label70
label69:
       mov  rbx,  1
       jmp  label71
label70:
       mov  rbx,  0
       jmp  label71
label71:
       cmp  rbx,  0
       jz  label67
label66:
       mov  rax,  0
       add  rsp,  208
       pop  rbp
       ret  
       jmp  label68
label67:
       jmp  label68
label68:
       jmp  label62
label62:
       mov  r11,  r11
       add  r11,  1
       mov  r11,  r11
       jmp  label61
label60:
       mov  rax,  1
       add  rsp,  208
       pop  rbp
       ret  
       add  rsp,  208
       pop  rbp
       ret  
merge:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  112
       mov  r11,  0
       jmp  label74
label74:
       mov  r14,  qword[now]
       cmp  r11,  r14
       jge  label77
label76:
       mov  rbx,  1
       jmp  label78
label77:
       mov  rbx,  0
       jmp  label78
label78:
       cmp  rbx,  0
       jz  label73
label72:
       mov  r13,  qword[a]
       mov  rbx,  r13
       mov  r15,  r11
       add  r15,  1
       mov  r14,  qword [rbx + r15 * 8]
       cmp  r14,  0
       jne  label83
label82:
       mov  rbx,  1
       jmp  label84
label83:
       mov  rbx,  0
       jmp  label84
label84:
       cmp  rbx,  0
       jz  label80
label79:
       mov  rbx,  r11
       mov  rbx,  rbx
       add  rbx,  1
       mov  rbx,  rbx
       mov  r10,  rbx
       jmp  label87
label87:
       mov  r13,  qword[now]
       cmp  r10,  r13
       jge  label90
label89:
       mov  rbx,  1
       jmp  label91
label90:
       mov  rbx,  0
       jmp  label91
label91:
       cmp  rbx,  0
       jz  label86
label85:
       mov  r15,  qword[a]
       mov  rbx,  r15
       mov  r14,  r10
       add  r14,  1
       mov  r13,  qword [rbx + r14 * 8]
       cmp  r13,  0
       je  label96
label95:
       mov  rbx,  1
       jmp  label97
label96:
       mov  rbx,  0
       jmp  label97
label97:
       cmp  rbx,  0
       jz  label93
label92:
       push  r11
       push  r10
       push  rbp
       push  rbx
       mov  rdi,  r11
       mov  rsi,  r10
       call  swap
       pop  rbx
       pop  rbp
       pop  r10
       pop  r11
       jmp  label86
       jmp  label94
label93:
       jmp  label94
label94:
       jmp  label88
label88:
       mov  r10,  r10
       add  r10,  1
       mov  r10,  r10
       jmp  label87
label86:
       jmp  label81
label80:
       jmp  label81
label81:
       jmp  label75
label75:
       mov  r11,  r11
       add  r11,  1
       mov  r11,  r11
       jmp  label74
label73:
       mov  r11,  0
       jmp  label100
label100:
       mov  r15,  qword[now]
       cmp  r11,  r15
       jge  label103
label102:
       mov  rbx,  1
       jmp  label104
label103:
       mov  rbx,  0
       jmp  label104
label104:
       cmp  rbx,  0
       jz  label99
label98:
       mov  r14,  qword[a]
       mov  rbx,  r14
       mov  r13,  r11
       add  r13,  1
       mov  r15,  qword [rbx + r13 * 8]
       cmp  r15,  0
       jne  label109
label108:
       mov  rbx,  1
       jmp  label110
label109:
       mov  rbx,  0
       jmp  label110
label110:
       cmp  rbx,  0
       jz  label106
label105:
       mov  qword[now],  r11
       jmp  label99
       jmp  label107
label106:
       jmp  label107
label107:
       jmp  label101
label101:
       mov  r11,  r11
       add  r11,  1
       mov  r11,  r11
       jmp  label100
label99:
       add  rsp,  112
       pop  rbp
       ret  
       add  rsp,  112
       pop  rbp
       ret  
move:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  64
       mov  r10,  0
       jmp  label113
label113:
       mov  r14,  qword[now]
       cmp  r10,  r14
       jge  label116
label115:
       mov  rbx,  1
       jmp  label117
label116:
       mov  rbx,  0
       jmp  label117
label117:
       cmp  rbx,  0
       jz  label112
label111:
       mov  r13,  qword[a]
       mov  rbx,  r13
       mov  r15,  r10
       add  r15,  1
       mov  r14,  qword [rbx + r15 * 8]
       mov  r13,  r10
       add  r13,  1
       mov  r15,  r10
       add  r15,  1
       mov  r14,  qword [rbx + r15 * 8]
       mov  r14,  r14
       sub  r14,  1
       mov  qword [rbx + r13 * 8],  r14
       mov  rbx,  r10
       mov  rbx,  rbx
       add  rbx,  1
       mov  rbx,  rbx
       mov  r10,  rbx
       jmp  label114
label114:
       jmp  label113
label112:
       mov  r13,  qword[a]
       mov  rbx,  r13
       mov  r15,  qword[now]
       mov  r14,  qword[now]
       mov  r13,  r14
       add  r13,  1
       mov  qword [rbx + r13 * 8],  r15
       mov  r15,  qword[now]
       mov  rbx,  r15
       mov  r14,  qword[now]
       mov  r13,  qword[now]
       mov  r13,  r14
       add  r13,  1
       mov  qword[now],  r13
       add  rsp,  64
       pop  rbp
       ret  
       add  rsp,  64
       pop  rbp
       ret  
main:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  336
       mov  r12,  0
       mov  rbx,  0
       mov  qword [rbp-8],  0
       mov  r10,  3
       mov  r10,  r10
       imul  r10,  7
       mov  r10,  r10
       mov  r10,  r10
       mov  r10,  r10
       imul  r10,  10
       mov  r10,  r10
       mov  qword[n],  r10
       mov  qword[h],  0
       mov  rdi,  808
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       call  malloc
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       mov  r10,  rax
       mov  qword [r10 + 0],  100
       mov  qword[a],  r10
       mov  r15,  qword[M]
       mov  r10,  r15
       mov  r14,  qword[A]
       mov  rax,  r10
       mov  rdx,  0
       idiv  r14
       mov  r10,  rax
       mov  qword[Q],  r10
       mov  r13,  qword[M]
       mov  r10,  r13
       mov  r15,  qword[A]
       mov  rax,  r10
       mov  rdx,  0
       idiv  r15
       mov  r10,  rdx
       mov  qword[R],  r10
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       mov  rdi,  qword[n]
       call  pd
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       mov  r10,  rax
       mov  r10,  r10
       xor  r10,  1
       mov  r10,  r10
       cmp  r10,  0
       jz  label119
label118:
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       mov  rdi,  String_2
       call  println
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       mov  rax,  1
       add  rsp,  336
       pop  rbp
       ret  
       jmp  label120
label119:
       jmp  label120
label120:
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       mov  rdi,  String_3
       call  println
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       mov  rdi,  3654898
       call  initialize
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       call  random
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       mov  r10,  rax
       mov  r10,  r10
       mov  rax,  r10
       mov  r14,  10
       mov  rdx,  0
       idiv  r14
       mov  r10,  rdx
       mov  r10,  r10
       mov  r10,  r10
       add  r10,  1
       mov  r10,  r10
       mov  qword[now],  r10
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       mov  rdi,  qword[now]
       call  toString
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       mov  r10,  rax
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       mov  rdi,  r10
       call  println
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       jmp  label123
label123:
       mov  r13,  qword[now]
       mov  r10,  r13
       mov  r10,  r10
       sub  r10,  1
       mov  r10,  r10
       cmp  r12,  r10
       jge  label126
label125:
       mov  r10,  1
       jmp  label127
label126:
       mov  r10,  0
       jmp  label127
label127:
       cmp  r10,  0
       jz  label122
label121:
       mov  r15,  qword[a]
       mov  r10,  r15
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       call  random
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       mov  qword [rbp-16],  rax
       mov  r14,  qword [rbp-16]
       mov  qword [rbp-24],  r14
       mov  r13,  qword [rbp-24]
       mov  r15,  qword [rbp-24]
       mov  rax,  r13
       mov  r14,  10
       mov  rdx,  0
       idiv  r14
       mov  qword [rbp-24],  rdx
       mov  r13,  qword [rbp-24]
       mov  qword [rbp-32],  r13
       mov  r15,  qword [rbp-32]
       mov  r14,  qword [rbp-32]
       mov  r14,  r15
       add  r14,  1
       mov  qword [rbp-32],  r14
       mov  r13,  qword [rbp-32]
       mov  r15,  r12
       add  r15,  1
       mov  qword [r10 + r15 * 8],  r13
       jmp  label130
label130:
       mov  r14,  qword[a]
       mov  r10,  r14
       mov  r13,  r12
       add  r13,  1
       mov  r15,  qword [r10 + r13 * 8]
       mov  r10,  r15
       mov  r10,  r10
       add  r10,  rbx
       mov  r10,  r10
       mov  r14,  qword[n]
       cmp  r10,  r14
       jle  label132
label131:
       mov  r10,  1
       jmp  label133
label132:
       mov  r10,  0
       jmp  label133
label133:
       cmp  r10,  0
       jz  label129
label128:
       mov  r13,  qword[a]
       mov  qword [rbp-40],  r13
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       call  random
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       mov  r10,  rax
       mov  r10,  r10
       mov  rax,  r10
       mov  r15,  10
       mov  rdx,  0
       idiv  r15
       mov  r10,  rdx
       mov  r10,  r10
       mov  r10,  r10
       add  r10,  1
       mov  r10,  r10
       mov  r14,  qword [rbp-40]
       mov  r13,  r12
       add  r13,  1
       mov  qword [r14 + r13 * 8],  r10
       jmp  label130
label129:
       mov  r15,  qword[a]
       mov  r10,  r15
       mov  rbx,  rbx
       mov  r14,  r12
       add  r14,  1
       mov  r13,  qword [r10 + r14 * 8]
       mov  rbx,  rbx
       add  rbx,  r13
       mov  rbx,  rbx
       mov  rbx,  rbx
       jmp  label124
label124:
       mov  r12,  r12
       add  r12,  1
       mov  r12,  r12
       jmp  label123
label122:
       mov  r15,  qword[now]
       mov  qword [rbp-48],  r15
       mov  r14,  qword [rbp-48]
       mov  r13,  qword [rbp-48]
       mov  r13,  r14
       sub  r13,  1
       mov  qword [rbp-48],  r13
       mov  r15,  qword[a]
       mov  r10,  r15
       mov  r14,  qword[n]
       mov  r12,  r14
       mov  r12,  r12
       sub  r12,  rbx
       mov  r12,  r12
       mov  r13,  qword [rbp-48]
       mov  r15,  r13
       add  r15,  1
       mov  qword [r10 + r15 * 8],  r12
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       call  show
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       call  merge
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       jmp  label136
label136:
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       call  win
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       mov  rbx,  rax
       mov  rbx,  rbx
       xor  rbx,  1
       mov  rbx,  rbx
       cmp  rbx,  0
       jz  label135
label134:
       mov  r14,  qword [rbp-8]
       mov  r13,  qword [rbp-8]
       mov  r13,  r14
       add  r13,  1
       mov  qword [rbp-8],  r13
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       mov  rdi,  qword [rbp-8]
       call  toString
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       mov  rbx,  rax
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       mov  rdi,  String_4
       mov  rsi,  rbx
       call  Str_ADD
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       mov  rbx,  rax
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       mov  rdi,  rbx
       mov  rsi,  String_5
       call  Str_ADD
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       mov  rbx,  rax
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       mov  rdi,  rbx
       call  println
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       call  move
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       call  merge
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       call  show
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       jmp  label136
label135:
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       mov  rdi,  qword [rbp-8]
       call  toString
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       mov  rbx,  rax
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       mov  rdi,  String_6
       mov  rsi,  rbx
       call  Str_ADD
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       mov  rbx,  rax
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       mov  rdi,  rbx
       mov  rsi,  String_7
       call  Str_ADD
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       mov  rbx,  rax
       push  r11
       push  r12
       push  r10
       push  rbp
       push  rbx
       mov  rdi,  rbx
       call  println
       pop  rbx
       pop  rbp
       pop  r10
       pop  r12
       pop  r11
       mov  rax,  0
       add  rsp,  336
       pop  rbp
       ret  
       add  rsp,  336
       pop  rbp
       ret  

section .data
       dq  1
String_0:
       db  32, 0
       dq  0
String_1:
       db  0
       dq  79
String_2:
       db  83, 111, 114, 114, 121, 44, 32, 116, 104, 101, 32, 110, 117, 109, 98, 101, 114, 32, 110, 32, 109, 117, 115, 116, 32, 98, 101, 32, 97, 32, 110, 117, 109, 98, 101, 114, 32, 115, 46, 116, 46, 32, 116, 104, 101, 114, 101, 32, 101, 120, 105, 115, 116, 115, 32, 105, 32, 115, 97, 116, 105, 115, 102, 121, 105, 110, 103, 32, 110, 61, 49, 43, 50, 43, 46, 46, 46, 43, 105, 0
       dq  12
String_3:
       db  76, 101, 116, 39, 115, 32, 115, 116, 97, 114, 116, 33, 0
       dq  5
String_4:
       db  115, 116, 101, 112, 32, 0
       dq  1
String_5:
       db  58, 0
       dq  7
String_6:
       db  84, 111, 116, 97, 108, 58, 32, 0
       dq  8
String_7:
       db  32, 115, 116, 101, 112, 40, 115, 41, 0
A:
       dq  48271
M:
       dq  2147483647
seed:
       dq  1

section .bss

n:       resq  1
h:       resq  1
now:       resq  1
a:       resq  1
Q:       resq  1
R:       resq  1


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
