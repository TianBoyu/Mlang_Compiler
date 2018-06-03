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

__vector__init:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  80
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  rcx,  qword [rbp-16]
       cmp  rcx,  0
       jne  label4
label3:
       mov  qword [rbp-24],  1
       jmp  label5
label4:
       mov  qword [rbp-24],  0
label5:
       mov  rcx,  qword [rbp-24]
       cmp  rcx,  0
       jz  label1
label0:
       add  rsp,  80
       pop  rbp
       ret  
       jmp  label2
label1:
       jmp  label2
label2:
       mov  rax,  qword [rbp-16]
       mov  rdi,  rax
       call  size
       mov  qword [rbp-40],  rax
       mov  rcx,  qword [rbp-40]
       mov  r15,  rcx
       add  r15,  1
       imul  r15,  8
       mov  rdi,  r15
       call  malloc
       mov  qword [rbp-32],  rax
       mov  rcx,  qword [rbp-40]
       mov  rax,  qword [rbp-32]
       mov  qword [rax + 0],  rcx
       mov  rcx,  qword [rbp-32]
       mov  rax,  qword [rbp-8]
       mov  qword [rax + 8],  rcx
       mov  qword [rbp-48],  0
label8:
       mov  rax,  qword [rbp-16]
       mov  rdi,  rax
       call  size
       mov  qword [rbp-56],  rax
       mov  rcx,  qword [rbp-48]
       mov  rdx,  qword [rbp-56]
       cmp  rcx,  rdx
       jge  label11
label10:
       mov  qword [rbp-64],  1
       jmp  label12
label11:
       mov  qword [rbp-64],  0
label12:
       mov  rcx,  qword [rbp-64]
       cmp  rcx,  0
       jz  label7
label6:
       mov  rbx,  qword [rbp-16]
       mov  r8,  qword [rbp-48]
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  rdx,  qword [rbp-8]
       mov  rax,  qword [rdx + 8]
       mov  rcx,  qword [rbp-48]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  r9
label9:
       mov  rax,  qword [rbp-48]
       add  rax,  1
       mov  qword [rbp-48],  rax
       jmp  label8
label7:
       add  rsp,  80
       pop  rbp
       ret  
__vector__getDim:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  32
       mov  qword [rbp-8],  rdi
       mov  rcx,  qword [rbp-8]
       mov  rdx,  qword [rcx + 8]
       cmp  rdx,  0
       jne  label17
label16:
       mov  qword [rbp-16],  1
       jmp  label18
label17:
       mov  qword [rbp-16],  0
label18:
       mov  rcx,  qword [rbp-16]
       cmp  rcx,  0
       jz  label14
label13:
       mov  rax,  0
       add  rsp,  32
       pop  rbp
       ret  
       jmp  label15
label14:
       jmp  label15
label15:
       mov  rax,  qword [rbp-8]
       mov  rax,  qword [rax + 8]
       mov  rdi,  rax
       call  size
       mov  qword [rbp-24],  rax
       mov  rax,  qword [rbp-24]
       add  rsp,  32
       pop  rbp
       ret  
       add  rsp,  32
       pop  rbp
       ret  
__vector__dot:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  64
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  qword [rbp-24],  0
       mov  qword [rbp-32],  0
label21:
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       call  __vector__getDim
       mov  qword [rbp-40],  rax
       mov  rcx,  qword [rbp-24]
       mov  rdx,  qword [rbp-40]
       cmp  rcx,  rdx
       jge  label23
label22:
       mov  qword [rbp-48],  1
       jmp  label24
label23:
       mov  qword [rbp-48],  0
label24:
       mov  rcx,  qword [rbp-48]
       cmp  rcx,  0
       jz  label20
label19:
       mov  rbx,  qword [rbp-8]
       mov  rcx,  qword [rbx + 8]
       mov  rdx,  qword [rbp-24]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  r11,  qword [rbp-16]
       mov  r9,  qword [r11 + 8]
       mov  r10,  qword [rbp-24]
       add  r10,  1
       mov  r12,  qword [r9 + r10 * 8]
       imul  rax,  r12
       mov  qword [rbp-56],  rax
       mov  rax,  qword [rbp-56]
       mov  qword [rbp-32],  rax
       mov  rax,  qword [rbp-24]
       add  rax,  1
       mov  qword [rbp-24],  rax
       jmp  label21
label20:
       mov  rax,  qword [rbp-32]
       add  rsp,  64
       pop  rbp
       ret  
       add  rsp,  64
       pop  rbp
       ret  
__vector__scalarInPlaceMultiply:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  64
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  rcx,  qword [rbp-8]
       mov  rdx,  qword [rcx + 8]
       cmp  rdx,  0
       jne  label29
label28:
       mov  qword [rbp-24],  1
       jmp  label30
label29:
       mov  qword [rbp-24],  0
label30:
       mov  rcx,  qword [rbp-24]
       cmp  rcx,  0
       jz  label26
label25:
       add  rsp,  64
       pop  rbp
       ret  
       jmp  label27
label26:
       jmp  label27
label27:
       mov  qword [rbp-32],  0
label33:
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       call  __vector__getDim
       mov  qword [rbp-40],  rax
       mov  rcx,  qword [rbp-32]
       mov  rdx,  qword [rbp-40]
       cmp  rcx,  rdx
       jge  label36
label35:
       mov  qword [rbp-48],  1
       jmp  label37
label36:
       mov  qword [rbp-48],  0
label37:
       mov  rcx,  qword [rbp-48]
       cmp  rcx,  0
       jz  label32
label31:
       mov  rax,  qword [rbp-16]
       mov  r8,  qword [rbp-8]
       mov  rdx,  qword [r8 + 8]
       mov  rbx,  qword [rbp-32]
       add  rbx,  1
       mov  r9,  qword [rdx + rbx * 8]
       imul  rax,  r9
       mov  qword [rbp-56],  rax
       mov  rbx,  qword [rbp-56]
       mov  rdx,  qword [rbp-8]
       mov  rax,  qword [rdx + 8]
       mov  rcx,  qword [rbp-32]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rbx
label34:
       mov  rax,  qword [rbp-32]
       add  rax,  1
       mov  qword [rbp-32],  rax
       jmp  label33
label32:
       mov  rax,  qword [rbp-8]
       add  rsp,  64
       pop  rbp
       ret  
       add  rsp,  64
       pop  rbp
       ret  
__vector__add:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  144
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       call  __vector__getDim
       mov  qword [rbp-24],  rax
       mov  rax,  qword [rbp-16]
       mov  rdi,  rax
       call  __vector__getDim
       mov  qword [rbp-32],  rax
       mov  rcx,  qword [rbp-24]
       mov  rdx,  qword [rbp-32]
       cmp  rcx,  rdx
       je  label47
label46:
       mov  qword [rbp-40],  1
       jmp  label48
label47:
       mov  qword [rbp-40],  0
label48:
       mov  rcx,  qword [rbp-40]
       cmp  rcx,  0
       jz  label41
label42:
       jmp  label43
label41:
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       call  __vector__getDim
       mov  qword [rbp-48],  rax
       mov  rcx,  qword [rbp-48]
       cmp  rcx,  0
       jne  label50
label49:
       mov  qword [rbp-56],  1
       jmp  label51
label50:
       mov  qword [rbp-56],  0
label51:
       mov  rcx,  qword [rbp-56]
       cmp  rcx,  0
       jz  label44
label43:
       mov  qword [rbp-64],  1
       jmp  label45
label44:
       mov  qword [rbp-64],  0
label45:
       mov  rcx,  qword [rbp-64]
       cmp  rcx,  0
       jz  label39
label38:
       add  rsp,  144
       pop  rbp
       ret  
       jmp  label40
label39:
       jmp  label40
label40:
       mov  rdi,  72
       call  malloc
       mov  qword [rbp-80],  rax
       mov  rax,  qword [rbp-80]
       mov  qword [rbp-72],  rax
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       call  __vector__getDim
       mov  qword [rbp-104],  rax
       mov  rcx,  qword [rbp-104]
       mov  r15,  rcx
       add  r15,  1
       imul  r15,  8
       mov  rdi,  r15
       call  malloc
       mov  qword [rbp-96],  rax
       mov  rcx,  qword [rbp-104]
       mov  rax,  qword [rbp-96]
       mov  qword [rax + 0],  rcx
       mov  rcx,  qword [rbp-96]
       mov  rax,  qword [rbp-72]
       mov  qword [rax + 8],  rcx
       mov  qword [rbp-88],  0
label54:
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       call  __vector__getDim
       mov  qword [rbp-112],  rax
       mov  rcx,  qword [rbp-88]
       mov  rdx,  qword [rbp-112]
       cmp  rcx,  rdx
       jge  label57
label56:
       mov  qword [rbp-120],  1
       jmp  label58
label57:
       mov  qword [rbp-120],  0
label58:
       mov  rcx,  qword [rbp-120]
       cmp  rcx,  0
       jz  label53
label52:
       mov  rbx,  qword [rbp-8]
       mov  rcx,  qword [rbx + 8]
       mov  rdx,  qword [rbp-88]
       add  rdx,  1
       mov  rax,  qword [rcx + rdx * 8]
       mov  r11,  qword [rbp-16]
       mov  r9,  qword [r11 + 8]
       mov  r10,  qword [rbp-88]
       add  r10,  1
       mov  r12,  qword [r9 + r10 * 8]
       add  rax,  r12
       mov  qword [rbp-128],  rax
       mov  rbx,  qword [rbp-128]
       mov  rdx,  qword [rbp-72]
       mov  rax,  qword [rdx + 8]
       mov  rcx,  qword [rbp-88]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rbx
label55:
       mov  rax,  qword [rbp-88]
       add  rax,  1
       mov  qword [rbp-88],  rax
       jmp  label54
label53:
       mov  rax,  qword [rbp-72]
       add  rsp,  144
       pop  rbp
       ret  
       add  rsp,  144
       pop  rbp
       ret  
__vector__set:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  48
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  qword [rbp-24],  rdx
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       call  __vector__getDim
       mov  qword [rbp-32],  rax
       mov  rcx,  qword [rbp-32]
       mov  rdx,  qword [rbp-16]
       cmp  rcx,  rdx
       jge  label63
label62:
       mov  qword [rbp-40],  1
       jmp  label64
label63:
       mov  qword [rbp-40],  0
label64:
       mov  rcx,  qword [rbp-40]
       cmp  rcx,  0
       jz  label60
label59:
       mov  rax,  0
       add  rsp,  48
       pop  rbp
       ret  
       jmp  label61
label60:
       jmp  label61
label61:
       mov  rbx,  qword [rbp-24]
       mov  rdx,  qword [rbp-8]
       mov  rax,  qword [rdx + 8]
       mov  rcx,  qword [rbp-16]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rbx
       mov  rax,  1
       add  rsp,  48
       pop  rbp
       ret  
       add  rsp,  48
       pop  rbp
       ret  
__vector__tostring:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  112
       mov  qword [rbp-8],  rdi
       mov  rax,  String_0
       mov  qword [rbp-24],  rax
       mov  rax,  qword [rbp-24]
       mov  qword [rbp-16],  rax
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       call  __vector__getDim
       mov  qword [rbp-32],  rax
       mov  rcx,  qword [rbp-32]
       cmp  rcx,  0
       jle  label69
label68:
       mov  qword [rbp-40],  1
       jmp  label70
label69:
       mov  qword [rbp-40],  0
label70:
       mov  rcx,  qword [rbp-40]
       cmp  rcx,  0
       jz  label66
label65:
       mov  rcx,  qword [rbp-8]
       mov  rax,  qword [rcx + 8]
       mov  rax,  qword [rax + 8]
       mov  rdi,  rax
       call  toString
       mov  qword [rbp-56],  rax
       mov  rax,  qword [rbp-16]
       mov  rdi,  rax
       mov  rax,  qword [rbp-56]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-48],  rax
       mov  rax,  qword [rbp-48]
       mov  qword [rbp-16],  rax
       jmp  label67
label66:
       jmp  label67
label67:
       mov  qword [rbp-64],  1
label73:
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       call  __vector__getDim
       mov  qword [rbp-72],  rax
       mov  rcx,  qword [rbp-64]
       mov  rdx,  qword [rbp-72]
       cmp  rcx,  rdx
       jge  label76
label75:
       mov  qword [rbp-80],  1
       jmp  label77
label76:
       mov  qword [rbp-80],  0
label77:
       mov  rcx,  qword [rbp-80]
       cmp  rcx,  0
       jz  label72
label71:
       mov  rax,  qword [rbp-16]
       mov  rdi,  rax
       mov  rax,  String_1
       mov  qword [rbp-104],  rax
       mov  rax,  qword [rbp-104]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-96],  rax
       mov  rdx,  qword [rbp-8]
       mov  rax,  qword [rdx + 8]
       mov  rcx,  qword [rbp-64]
       add  rcx,  1
       mov  rax,  qword [rax + rcx * 8]
       mov  rdi,  rax
       call  toString
       mov  qword [rbp-112],  rax
       mov  rax,  qword [rbp-96]
       mov  rdi,  rax
       mov  rax,  qword [rbp-112]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-88],  rax
       mov  rax,  qword [rbp-88]
       mov  qword [rbp-16],  rax
label74:
       mov  rax,  qword [rbp-64]
       add  rax,  1
       mov  qword [rbp-64],  rax
       jmp  label73
label72:
       mov  rax,  qword [rbp-16]
       mov  rdi,  rax
       mov  rax,  String_2
       mov  qword [rbp-128],  rax
       mov  rax,  qword [rbp-128]
       mov  rsi,  rax
       call  Str_ADD
       mov  qword [rbp-120],  rax
       mov  rax,  qword [rbp-120]
       mov  qword [rbp-16],  rax
       mov  rax,  qword [rbp-16]
       add  rsp,  112
       pop  rbp
       ret  
       add  rsp,  112
       pop  rbp
       ret  
__vector__copy:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  96
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  rcx,  qword [rbp-16]
       cmp  rcx,  0
       jne  label82
label81:
       mov  qword [rbp-24],  1
       jmp  label83
label82:
       mov  qword [rbp-24],  0
label83:
       mov  rcx,  qword [rbp-24]
       cmp  rcx,  0
       jz  label79
label78:
       mov  rax,  0
       add  rsp,  96
       pop  rbp
       ret  
       jmp  label80
label79:
       jmp  label80
label80:
       mov  rax,  qword [rbp-16]
       mov  rdi,  rax
       call  __vector__getDim
       mov  qword [rbp-32],  rax
       mov  rcx,  qword [rbp-32]
       cmp  rcx,  0
       jne  label88
label87:
       mov  qword [rbp-40],  1
       jmp  label89
label88:
       mov  qword [rbp-40],  0
label89:
       mov  rcx,  qword [rbp-40]
       cmp  rcx,  0
       jz  label85
label84:
       jmp  label86
label85:
       mov  rax,  qword [rbp-16]
       mov  rdi,  rax
       call  __vector__getDim
       mov  qword [rbp-56],  rax
       mov  rcx,  qword [rbp-56]
       mov  r15,  rcx
       add  r15,  1
       imul  r15,  8
       mov  rdi,  r15
       call  malloc
       mov  qword [rbp-48],  rax
       mov  rcx,  qword [rbp-56]
       mov  rax,  qword [rbp-48]
       mov  qword [rax + 0],  rcx
       mov  rcx,  qword [rbp-48]
       mov  rax,  qword [rbp-8]
       mov  qword [rax + 8],  rcx
       mov  qword [rbp-64],  0
label92:
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       call  __vector__getDim
       mov  qword [rbp-72],  rax
       mov  rcx,  qword [rbp-64]
       mov  rdx,  qword [rbp-72]
       cmp  rcx,  rdx
       jge  label95
label94:
       mov  qword [rbp-80],  1
       jmp  label96
label95:
       mov  qword [rbp-80],  0
label96:
       mov  rcx,  qword [rbp-80]
       cmp  rcx,  0
       jz  label91
label90:
       mov  r9,  qword [rbp-16]
       mov  rbx,  qword [r9 + 8]
       mov  r8,  qword [rbp-64]
       add  r8,  1
       mov  r10,  qword [rbx + r8 * 8]
       mov  rdx,  qword [rbp-8]
       mov  rax,  qword [rdx + 8]
       mov  rcx,  qword [rbp-64]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  r10
label93:
       mov  rax,  qword [rbp-64]
       add  rax,  1
       mov  qword [rbp-64],  rax
       jmp  label92
label91:
       jmp  label86
label86:
       mov  rax,  1
       add  rsp,  96
       pop  rbp
       ret  
       add  rsp,  96
       pop  rbp
       ret  
main:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  176
       mov  rdi,  72
       call  malloc
       mov  qword [rbp-16],  rax
       mov  rax,  qword [rbp-16]
       mov  qword [rbp-8],  rax
       mov  rdi,  88
       call  malloc
       mov  qword [rbp-32],  rax
       mov  rax,  qword [rbp-32]
       mov  qword [rax + 0],  10
       mov  rax,  qword [rbp-32]
       mov  qword [rbp-24],  rax
       mov  qword [rbp-40],  0
label99:
       mov  rcx,  qword [rbp-40]
       cmp  rcx,  10
       jge  label102
label101:
       mov  qword [rbp-48],  1
       jmp  label103
label102:
       mov  qword [rbp-48],  0
label103:
       mov  rcx,  qword [rbp-48]
       cmp  rcx,  0
       jz  label98
label97:
       mov  rax,  9
       mov  rcx,  qword [rbp-40]
       sub  rax,  rcx
       mov  qword [rbp-56],  rax
       mov  rdx,  qword [rbp-56]
       mov  rax,  qword [rbp-24]
       mov  rcx,  qword [rbp-40]
       add  rcx,  1
       mov  qword [rax + rcx * 8],  rdx
label100:
       mov  rax,  qword [rbp-40]
       add  rax,  1
       mov  qword [rbp-40],  rax
       jmp  label99
label98:
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       mov  rax,  qword [rbp-24]
       mov  rsi,  rax
       call  __vector__init
       mov  rax,  String_3
       mov  qword [rbp-64],  rax
       mov  rax,  qword [rbp-64]
       mov  rdi,  rax
       call  print
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       call  __vector__tostring
       mov  qword [rbp-72],  rax
       mov  rax,  qword [rbp-72]
       mov  rdi,  rax
       call  println
       mov  rdi,  72
       call  malloc
       mov  qword [rbp-88],  rax
       mov  rax,  qword [rbp-88]
       mov  qword [rbp-80],  rax
       mov  rax,  qword [rbp-80]
       mov  rdi,  rax
       mov  rax,  qword [rbp-8]
       mov  rsi,  rax
       call  __vector__copy
       mov  qword [rbp-96],  rax
       mov  rax,  qword [rbp-80]
       mov  rdi,  rax
       mov  rsi,  3
       mov  rdx,  817
       call  __vector__set
       mov  qword [rbp-104],  rax
       mov  rcx,  qword [rbp-104]
       cmp  rcx,  0
       jz  label105
label104:
       mov  rax,  String_4
       mov  qword [rbp-112],  rax
       mov  rax,  qword [rbp-112]
       mov  rdi,  rax
       call  println
       jmp  label106
label105:
       jmp  label106
label106:
       mov  rax,  String_5
       mov  qword [rbp-120],  rax
       mov  rax,  qword [rbp-120]
       mov  rdi,  rax
       call  print
       mov  rax,  qword [rbp-80]
       mov  rdi,  rax
       call  __vector__tostring
       mov  qword [rbp-128],  rax
       mov  rax,  qword [rbp-128]
       mov  rdi,  rax
       call  println
       mov  rax,  String_6
       mov  qword [rbp-136],  rax
       mov  rax,  qword [rbp-136]
       mov  rdi,  rax
       call  print
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       mov  rax,  qword [rbp-80]
       mov  rsi,  rax
       call  __vector__add
       mov  qword [rbp-144],  rax
       mov  rax,  qword [rbp-144]
       mov  rdi,  rax
       call  __vector__tostring
       mov  qword [rbp-152],  rax
       mov  rax,  qword [rbp-152]
       mov  rdi,  rax
       call  println
       mov  rax,  String_7
       mov  qword [rbp-160],  rax
       mov  rax,  qword [rbp-160]
       mov  rdi,  rax
       call  print
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       mov  rax,  qword [rbp-80]
       mov  rsi,  rax
       call  __vector__dot
       mov  qword [rbp-176],  rax
       mov  rax,  qword [rbp-176]
       mov  rdi,  rax
       call  toString
       mov  qword [rbp-168],  rax
       mov  rax,  qword [rbp-168]
       mov  rdi,  rax
       call  println
       mov  rax,  String_8
       mov  qword [rbp-184],  rax
       mov  rax,  qword [rbp-184]
       mov  rdi,  rax
       call  print
       mov  rax,  1
       shl  rax,  3
       mov  qword [rbp-200],  rax
       mov  rax,  qword [rbp-80]
       mov  rdi,  rax
       mov  rax,  qword [rbp-200]
       mov  rsi,  rax
       call  __vector__scalarInPlaceMultiply
       mov  qword [rbp-192],  rax
       mov  rax,  qword [rbp-192]
       mov  rdi,  rax
       call  __vector__tostring
       mov  qword [rbp-208],  rax
       mov  rax,  qword [rbp-208]
       mov  rdi,  rax
       call  println
       mov  rax,  0
       add  rsp,  176
       pop  rbp
       ret  
       add  rsp,  176
       pop  rbp
       ret  

section .data
       dq  2
String_0:
       db  40, 32, 0
       dq  2
String_1:
       db  44, 32, 0
       dq  2
String_2:
       db  32, 41, 0
       dq  10
String_3:
       db  118, 101, 99, 116, 111, 114, 32, 120, 58, 32, 0
       dq  8
String_4:
       db  101, 120, 99, 105, 116, 101, 100, 33, 0
       dq  10
String_5:
       db  118, 101, 99, 116, 111, 114, 32, 121, 58, 32, 0
       dq  7
String_6:
       db  120, 32, 43, 32, 121, 58, 32, 0
       dq  7
String_7:
       db  120, 32, 42, 32, 121, 58, 32, 0
       dq  14
String_8:
       db  40, 49, 32, 60, 60, 32, 51, 41, 32, 42, 32, 121, 58, 32, 0

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
