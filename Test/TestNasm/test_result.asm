global    i4
global    i3
global    heapsort
global    calc
global    i10
global    restore
global    heap
global    i8
global    mergesort
global    a_left
global    i13
global    i14
global    i6
global    a_right
global    i5
global    i12
global    N
global    i11
global    i2
global    i7
global    bak
global    quicksort
global    a
global    i1
global    n
global    main
global    i9


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

__A__Optimizer:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  2096
       mov  qword [rbp-8],  rdi
       mov  rdi,  24
       call  malloc
       mov  qword [rbp-24],  rax
       mov  rax,  qword [rbp-24]
       mov  qword [rax + 0],  2
       mov  qword [rbp-32],  0
label0:
       mov  rax,  qword [rbp-24]
       mov  rbx,  qword [rbp-32]
       add  rbx,  1
       mov  r8,  qword [rax + rbx * 8]
       mov  qword [rbp-40],  r8
       mov  rdi,  24
       call  malloc
       mov  qword [rbp-40],  rax
       mov  rax,  qword [rbp-40]
       mov  qword [rax + 0],  2
       mov  qword [rbp-48],  0
label2:
       mov  rax,  qword [rbp-40]
       mov  rbx,  qword [rbp-48]
       add  rbx,  1
       mov  r8,  qword [rax + rbx * 8]
       mov  qword [rbp-56],  r8
       mov  rdi,  24
       call  malloc
       mov  qword [rbp-56],  rax
       mov  rax,  qword [rbp-56]
       mov  qword [rax + 0],  2
       mov  qword [rbp-64],  0
label4:
       mov  rax,  qword [rbp-56]
       mov  rbx,  qword [rbp-64]
       add  rbx,  1
       mov  r8,  qword [rax + rbx * 8]
       mov  qword [rbp-72],  r8
       mov  rdi,  24
       call  malloc
       mov  qword [rbp-72],  rax
       mov  rax,  qword [rbp-72]
       mov  qword [rax + 0],  2
       mov  qword [rbp-80],  0
label6:
       mov  rax,  qword [rbp-72]
       mov  rbx,  qword [rbp-80]
       add  rbx,  1
       mov  r8,  qword [rax + rbx * 8]
       mov  qword [rbp-88],  r8
       mov  rdi,  24
       call  malloc
       mov  qword [rbp-88],  rax
       mov  rax,  qword [rbp-88]
       mov  qword [rax + 0],  2
       mov  qword [rbp-96],  0
label8:
       mov  rax,  qword [rbp-88]
       mov  rbx,  qword [rbp-96]
       add  rbx,  1
       mov  r8,  qword [rax + rbx * 8]
       mov  qword [rbp-104],  r8
       mov  rdi,  24
       call  malloc
       mov  qword [rbp-104],  rax
       mov  rax,  qword [rbp-104]
       mov  qword [rax + 0],  2
       mov  qword [rbp-112],  0
label10:
       mov  rax,  qword [rbp-104]
       mov  rbx,  qword [rbp-112]
       add  rbx,  1
       mov  r8,  qword [rax + rbx * 8]
       mov  qword [rbp-120],  r8
       mov  rdi,  24
       call  malloc
       mov  qword [rbp-120],  rax
       mov  rax,  qword [rbp-120]
       mov  qword [rax + 0],  2
       mov  qword [rbp-128],  0
label12:
       mov  rax,  qword [rbp-120]
       mov  rbx,  qword [rbp-128]
       add  rbx,  1
       mov  r8,  qword [rax + rbx * 8]
       mov  qword [rbp-136],  r8
       mov  rdi,  24
       call  malloc
       mov  qword [rbp-136],  rax
       mov  rax,  qword [rbp-136]
       mov  qword [rax + 0],  2
       mov  qword [rbp-144],  0
label14:
       mov  rax,  qword [rbp-136]
       mov  rbx,  qword [rbp-144]
       add  rbx,  1
       mov  r8,  qword [rax + rbx * 8]
       mov  qword [rbp-152],  r8
       mov  rdi,  24
       call  malloc
       mov  qword [rbp-152],  rax
       mov  rax,  qword [rbp-152]
       mov  qword [rax + 0],  2
       mov  qword [rbp-160],  0
label16:
       mov  rax,  qword [rbp-152]
       mov  rbx,  qword [rbp-160]
       add  rbx,  1
       mov  r8,  qword [rax + rbx * 8]
       mov  qword [rbp-168],  r8
       mov  rdi,  24
       call  malloc
       mov  qword [rbp-168],  rax
       mov  rax,  qword [rbp-168]
       mov  qword [rax + 0],  2
       mov  qword [rbp-176],  0
       mov  r8,  qword [rbp-168]
       mov  rax,  qword [rbp-152]
       mov  rbx,  qword [rbp-160]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  rax,  qword [rbp-160]
       add  rax,  1
       mov  qword [rbp-160],  rax
       mov  rbx,  qword [rbp-160]
       cmp  rbx,  2
       jg  label17
       jmp  label16
label17:
       mov  r8,  qword [rbp-152]
       mov  rax,  qword [rbp-136]
       mov  rbx,  qword [rbp-144]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  rax,  qword [rbp-144]
       add  rax,  1
       mov  qword [rbp-144],  rax
       mov  rbx,  qword [rbp-144]
       cmp  rbx,  2
       jg  label15
       jmp  label14
label15:
       mov  r8,  qword [rbp-136]
       mov  rax,  qword [rbp-120]
       mov  rbx,  qword [rbp-128]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  rax,  qword [rbp-128]
       add  rax,  1
       mov  qword [rbp-128],  rax
       mov  rbx,  qword [rbp-128]
       cmp  rbx,  2
       jg  label13
       jmp  label12
label13:
       mov  r8,  qword [rbp-120]
       mov  rax,  qword [rbp-104]
       mov  rbx,  qword [rbp-112]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  rax,  qword [rbp-112]
       add  rax,  1
       mov  qword [rbp-112],  rax
       mov  rbx,  qword [rbp-112]
       cmp  rbx,  2
       jg  label11
       jmp  label10
label11:
       mov  r8,  qword [rbp-104]
       mov  rax,  qword [rbp-88]
       mov  rbx,  qword [rbp-96]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  rax,  qword [rbp-96]
       add  rax,  1
       mov  qword [rbp-96],  rax
       mov  rbx,  qword [rbp-96]
       cmp  rbx,  2
       jg  label9
       jmp  label8
label9:
       mov  r8,  qword [rbp-88]
       mov  rax,  qword [rbp-72]
       mov  rbx,  qword [rbp-80]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  rax,  qword [rbp-80]
       add  rax,  1
       mov  qword [rbp-80],  rax
       mov  rbx,  qword [rbp-80]
       cmp  rbx,  2
       jg  label7
       jmp  label6
label7:
       mov  r8,  qword [rbp-72]
       mov  rax,  qword [rbp-56]
       mov  rbx,  qword [rbp-64]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  rax,  qword [rbp-64]
       add  rax,  1
       mov  qword [rbp-64],  rax
       mov  rbx,  qword [rbp-64]
       cmp  rbx,  2
       jg  label5
       jmp  label4
label5:
       mov  r8,  qword [rbp-56]
       mov  rax,  qword [rbp-40]
       mov  rbx,  qword [rbp-48]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  rax,  qword [rbp-48]
       add  rax,  1
       mov  qword [rbp-48],  rax
       mov  rbx,  qword [rbp-48]
       cmp  rbx,  2
       jg  label3
       jmp  label2
label3:
       mov  r8,  qword [rbp-40]
       mov  rax,  qword [rbp-24]
       mov  rbx,  qword [rbp-32]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  rax,  qword [rbp-32]
       add  rax,  1
       mov  qword [rbp-32],  rax
       mov  rbx,  qword [rbp-32]
       cmp  rbx,  2
       jg  label1
       jmp  label0
label1:
       mov  rax,  qword [rbp-24]
       mov  qword [rbp-16],  rax
       mov  qword [rbp-376],  0
       mov  qword [rbp-368],  1
label22:
       mov  rbx,  qword [rbp-368]
       cmp  rbx,  1000
       jg  label25
label24:
       mov  qword [rbp-384],  1
       jmp  label26
label25:
       mov  qword [rbp-384],  0
label26:
       mov  rbx,  qword [rbp-384]
       cmp  rbx,  0
       jz  label21
label20:
       mov  rax,  qword [rbp-16]
       mov  qword [rbp-392],  rax
       mov  rax,  qword [rbp-392]
       mov  rbx,  qword [rax + 8]
       mov  qword [rbp-400],  rbx
       mov  rax,  qword [rbp-400]
       mov  rbx,  qword [rax + 16]
       mov  qword [rbp-408],  rbx
       mov  rax,  qword [rbp-408]
       mov  rbx,  qword [rax + 8]
       mov  qword [rbp-416],  rbx
       mov  rax,  qword [rbp-416]
       mov  rbx,  qword [rax + 16]
       mov  qword [rbp-424],  rbx
       mov  rax,  qword [rbp-424]
       mov  rbx,  qword [rax + 8]
       mov  qword [rbp-432],  rbx
       mov  rax,  qword [rbp-432]
       mov  rbx,  qword [rax + 16]
       mov  qword [rbp-440],  rbx
       mov  rax,  qword [rbp-440]
       mov  rbx,  qword [rax + 8]
       mov  qword [rbp-448],  rbx
       mov  rax,  qword [rbp-448]
       mov  rbx,  qword [rax + 16]
       mov  qword [rbp-456],  rbx
       mov  rax,  qword [rbp-456]
       mov  rbx,  qword [rax + 8]
       mov  qword [rbp-464],  rbx
       mov  rax,  123
       mov  rbx,  qword [rbp-368]
       add  rax,  rbx
       mov  qword [rbp-472],  rax
       mov  rbx,  qword [rbp-472]
       mov  rax,  qword [rbp-464]
       mov  qword [rax + 16],  rbx
       mov  rax,  qword [rbp-16]
       mov  qword [rbp-480],  rax
       mov  rax,  qword [rbp-480]
       mov  rbx,  qword [rax + 8]
       mov  qword [rbp-488],  rbx
       mov  rax,  qword [rbp-488]
       mov  rbx,  qword [rax + 16]
       mov  qword [rbp-496],  rbx
       mov  rax,  qword [rbp-496]
       mov  rbx,  qword [rax + 8]
       mov  qword [rbp-504],  rbx
       mov  rax,  qword [rbp-504]
       mov  rbx,  qword [rax + 16]
       mov  qword [rbp-512],  rbx
       mov  rax,  qword [rbp-512]
       mov  rbx,  qword [rax + 8]
       mov  qword [rbp-520],  rbx
       mov  rax,  qword [rbp-520]
       mov  rbx,  qword [rax + 16]
       mov  qword [rbp-528],  rbx
       mov  rax,  qword [rbp-528]
       mov  rbx,  qword [rax + 8]
       mov  qword [rbp-536],  rbx
       mov  rax,  qword [rbp-536]
       mov  rbx,  qword [rax + 16]
       mov  qword [rbp-544],  rbx
       mov  rax,  qword [rbp-544]
       mov  rbx,  qword [rax + 8]
       mov  qword [rbp-552],  rbx
       mov  rax,  qword [rbp-376]
       mov  r8,  qword [rbp-552]
       mov  r9,  qword [r8 + 16]
       add  rax,  r9
       mov  qword [rbp-560],  rax
       mov  rax,  qword [rbp-560]
       mov  qword [rbp-376],  rax
label23:
       mov  rax,  qword [rbp-368]
       mov  qword [rbp-568],  rax
       mov  rax,  qword [rbp-368]
       add  rax,  1
       mov  qword [rbp-368],  rax
       jmp  label22
label21:
       mov  rax,  qword [rbp-376]
       mov  rdi,  rax
       call  toString
       mov  qword [rbp-576],  rax
       mov  rax,  qword [rbp-576]
       mov  rdi,  rax
       call  println
       mov  qword [rbp-368],  1
label29:
       mov  rbx,  qword [rbp-368]
       cmp  rbx,  1000000
       jg  label32
label31:
       mov  qword [rbp-584],  1
       jmp  label33
label32:
       mov  qword [rbp-584],  0
label33:
       mov  rbx,  qword [rbp-584]
       cmp  rbx,  0
       jz  label28
label27:
       mov  rax,  9876
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-592],  rdx
       mov  rax,  qword [rbp-592]
       imul  rax,  2345
       mov  qword [rbp-600],  rax
       mov  rax,  qword [rbp-600]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-608],  rdx
       mov  rax,  qword [rbp-608]
       imul  rax,  2345
       mov  qword [rbp-616],  rax
       mov  rax,  qword [rbp-616]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-624],  rdx
       mov  rax,  qword [rbp-624]
       imul  rax,  2345
       mov  qword [rbp-632],  rax
       mov  rax,  qword [rbp-632]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-640],  rdx
       mov  rax,  qword [rbp-640]
       imul  rax,  2345
       mov  qword [rbp-648],  rax
       mov  rax,  qword [rbp-648]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-656],  rdx
       mov  rax,  qword [rbp-656]
       imul  rax,  2345
       mov  qword [rbp-664],  rax
       mov  rax,  qword [rbp-664]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-672],  rdx
       mov  rax,  qword [rbp-672]
       imul  rax,  2345
       mov  qword [rbp-680],  rax
       mov  rax,  qword [rbp-680]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-688],  rdx
       mov  rax,  qword [rbp-688]
       imul  rax,  2345
       mov  qword [rbp-696],  rax
       mov  rax,  qword [rbp-696]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-704],  rdx
       mov  rax,  qword [rbp-704]
       imul  rax,  2345
       mov  qword [rbp-712],  rax
       mov  rax,  qword [rbp-712]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-720],  rdx
       mov  rax,  qword [rbp-720]
       imul  rax,  2345
       mov  qword [rbp-728],  rax
       mov  rax,  qword [rbp-728]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-736],  rdx
       mov  rax,  qword [rbp-736]
       imul  rax,  2345
       mov  qword [rbp-744],  rax
       mov  rax,  qword [rbp-744]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-752],  rdx
       mov  rax,  qword [rbp-752]
       imul  rax,  2345
       mov  qword [rbp-760],  rax
       mov  rax,  qword [rbp-760]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-768],  rdx
       mov  rax,  qword [rbp-768]
       imul  rax,  2345
       mov  qword [rbp-776],  rax
       mov  rax,  qword [rbp-776]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-784],  rdx
       mov  rax,  qword [rbp-784]
       imul  rax,  2345
       mov  qword [rbp-792],  rax
       mov  rax,  qword [rbp-792]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-800],  rdx
       mov  rax,  qword [rbp-800]
       imul  rax,  2345
       mov  qword [rbp-808],  rax
       mov  rax,  qword [rbp-808]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-816],  rdx
       mov  rax,  qword [rbp-816]
       imul  rax,  2345
       mov  qword [rbp-824],  rax
       mov  rax,  qword [rbp-824]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-832],  rdx
       mov  rax,  qword [rbp-832]
       imul  rax,  2345
       mov  qword [rbp-840],  rax
       mov  rax,  qword [rbp-840]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-848],  rdx
       mov  rax,  qword [rbp-848]
       imul  rax,  2345
       mov  qword [rbp-856],  rax
       mov  rax,  qword [rbp-856]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-864],  rdx
       mov  rax,  qword [rbp-864]
       imul  rax,  2345
       mov  qword [rbp-872],  rax
       mov  rax,  qword [rbp-872]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-880],  rdx
       mov  rax,  qword [rbp-880]
       imul  rax,  2345
       mov  qword [rbp-888],  rax
       mov  rax,  qword [rbp-888]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-896],  rdx
       mov  rax,  qword [rbp-896]
       imul  rax,  2345
       mov  qword [rbp-904],  rax
       mov  rax,  qword [rbp-904]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-912],  rdx
       mov  rax,  qword [rbp-912]
       imul  rax,  2345
       mov  qword [rbp-920],  rax
       mov  rax,  qword [rbp-920]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-928],  rdx
       mov  rax,  qword [rbp-928]
       imul  rax,  2345
       mov  qword [rbp-936],  rax
       mov  rax,  qword [rbp-936]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-944],  rdx
       mov  rax,  qword [rbp-944]
       imul  rax,  2345
       mov  qword [rbp-952],  rax
       mov  rax,  qword [rbp-952]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-960],  rdx
       mov  rax,  qword [rbp-960]
       imul  rax,  2345
       mov  qword [rbp-968],  rax
       mov  rax,  qword [rbp-968]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-976],  rdx
       mov  rax,  qword [rbp-976]
       imul  rax,  2345
       mov  qword [rbp-984],  rax
       mov  rax,  qword [rbp-984]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-992],  rdx
       mov  rax,  qword [rbp-992]
       imul  rax,  2345
       mov  qword [rbp-1000],  rax
       mov  rax,  qword [rbp-1000]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1008],  rdx
       mov  rax,  qword [rbp-1008]
       imul  rax,  2345
       mov  qword [rbp-1016],  rax
       mov  rax,  qword [rbp-1016]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1024],  rdx
       mov  rax,  qword [rbp-1024]
       imul  rax,  2345
       mov  qword [rbp-1032],  rax
       mov  rax,  qword [rbp-1032]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1040],  rdx
       mov  rax,  qword [rbp-1040]
       imul  rax,  2345
       mov  qword [rbp-1048],  rax
       mov  rax,  qword [rbp-1048]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1056],  rdx
       mov  rax,  qword [rbp-1056]
       imul  rax,  2345
       mov  qword [rbp-1064],  rax
       mov  rax,  qword [rbp-1064]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1072],  rdx
       mov  rax,  qword [rbp-1072]
       imul  rax,  2345
       mov  qword [rbp-1080],  rax
       mov  rax,  qword [rbp-1080]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1088],  rdx
       mov  rax,  qword [rbp-1088]
       imul  rax,  2345
       mov  qword [rbp-1096],  rax
       mov  rax,  qword [rbp-1096]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1104],  rdx
       mov  rax,  qword [rbp-1104]
       imul  rax,  2345
       mov  qword [rbp-1112],  rax
       mov  rax,  qword [rbp-1112]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1120],  rdx
       mov  rax,  qword [rbp-1120]
       imul  rax,  2345
       mov  qword [rbp-1128],  rax
       mov  rax,  qword [rbp-1128]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1136],  rdx
       mov  rax,  qword [rbp-1136]
       imul  rax,  2345
       mov  qword [rbp-1144],  rax
       mov  rax,  qword [rbp-1144]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1152],  rdx
       mov  rax,  qword [rbp-1152]
       imul  rax,  2345
       mov  qword [rbp-1160],  rax
       mov  rax,  qword [rbp-1160]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1168],  rdx
       mov  rax,  qword [rbp-1168]
       imul  rax,  2345
       mov  qword [rbp-1176],  rax
       mov  rax,  qword [rbp-1176]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1184],  rdx
       mov  rax,  qword [rbp-1184]
       imul  rax,  2345
       mov  qword [rbp-1192],  rax
       mov  rax,  qword [rbp-1192]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1200],  rdx
       mov  rax,  qword [rbp-1200]
       imul  rax,  2345
       mov  qword [rbp-1208],  rax
       mov  rax,  qword [rbp-1208]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1216],  rdx
       mov  rax,  qword [rbp-1216]
       imul  rax,  2345
       mov  qword [rbp-1224],  rax
       mov  rax,  qword [rbp-1224]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1232],  rdx
       mov  rax,  qword [rbp-1232]
       imul  rax,  2345
       mov  qword [rbp-1240],  rax
       mov  rax,  qword [rbp-1240]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1248],  rdx
       mov  rax,  qword [rbp-1248]
       imul  rax,  2345
       mov  qword [rbp-1256],  rax
       mov  rax,  qword [rbp-1256]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1264],  rdx
       mov  rax,  qword [rbp-1264]
       imul  rax,  2345
       mov  qword [rbp-1272],  rax
       mov  rax,  qword [rbp-1272]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1280],  rdx
       mov  rax,  qword [rbp-1280]
       imul  rax,  2345
       mov  qword [rbp-1288],  rax
       mov  rax,  qword [rbp-1288]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1296],  rdx
       mov  rax,  qword [rbp-1296]
       imul  rax,  2345
       mov  qword [rbp-1304],  rax
       mov  rax,  qword [rbp-1304]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1312],  rdx
       mov  rax,  qword [rbp-1312]
       imul  rax,  2345
       mov  qword [rbp-1320],  rax
       mov  rax,  qword [rbp-1320]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1328],  rdx
       mov  rax,  qword [rbp-1328]
       imul  rax,  2345
       mov  qword [rbp-1336],  rax
       mov  rax,  qword [rbp-1336]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1344],  rdx
       mov  rax,  qword [rbp-1344]
       imul  rax,  2345
       mov  qword [rbp-1352],  rax
       mov  rax,  qword [rbp-1352]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1360],  rdx
       mov  rax,  qword [rbp-1360]
       imul  rax,  2345
       mov  qword [rbp-1368],  rax
       mov  rax,  qword [rbp-1368]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1376],  rdx
       mov  rax,  qword [rbp-1376]
       imul  rax,  2345
       mov  qword [rbp-1384],  rax
       mov  rax,  qword [rbp-1384]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1392],  rdx
       mov  rax,  qword [rbp-1392]
       imul  rax,  2345
       mov  qword [rbp-1400],  rax
       mov  rax,  qword [rbp-1400]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1408],  rdx
       mov  rax,  qword [rbp-1408]
       imul  rax,  2345
       mov  qword [rbp-1416],  rax
       mov  rax,  qword [rbp-1416]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1424],  rdx
       mov  rax,  qword [rbp-1424]
       imul  rax,  2345
       mov  qword [rbp-1432],  rax
       mov  rax,  qword [rbp-1432]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1440],  rdx
       mov  rax,  qword [rbp-1440]
       imul  rax,  2345
       mov  qword [rbp-1448],  rax
       mov  rax,  qword [rbp-1448]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1456],  rdx
       mov  rax,  qword [rbp-1456]
       imul  rax,  2345
       mov  qword [rbp-1464],  rax
       mov  rax,  qword [rbp-1464]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1472],  rdx
       mov  rax,  qword [rbp-1472]
       imul  rax,  2345
       mov  qword [rbp-1480],  rax
       mov  rax,  qword [rbp-1480]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1488],  rdx
       mov  rax,  qword [rbp-1488]
       imul  rax,  2345
       mov  qword [rbp-1496],  rax
       mov  rax,  qword [rbp-1496]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1504],  rdx
       mov  rax,  qword [rbp-1504]
       imul  rax,  2345
       mov  qword [rbp-1512],  rax
       mov  rax,  qword [rbp-1512]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1520],  rdx
       mov  rax,  qword [rbp-1520]
       imul  rax,  2345
       mov  qword [rbp-1528],  rax
       mov  rax,  qword [rbp-1528]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1536],  rdx
       mov  rax,  qword [rbp-1536]
       imul  rax,  2345
       mov  qword [rbp-1544],  rax
       mov  rax,  qword [rbp-1544]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1552],  rdx
       mov  rax,  qword [rbp-1552]
       imul  rax,  2345
       mov  qword [rbp-1560],  rax
       mov  rax,  qword [rbp-1560]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1568],  rdx
       mov  rax,  qword [rbp-1568]
       imul  rax,  2345
       mov  qword [rbp-1576],  rax
       mov  rax,  qword [rbp-1576]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1584],  rdx
       mov  rax,  qword [rbp-1584]
       imul  rax,  2345
       mov  qword [rbp-1592],  rax
       mov  rax,  qword [rbp-1592]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1600],  rdx
       mov  rax,  qword [rbp-1600]
       imul  rax,  2345
       mov  qword [rbp-1608],  rax
       mov  rax,  qword [rbp-1608]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1616],  rdx
       mov  rax,  qword [rbp-1616]
       imul  rax,  2345
       mov  qword [rbp-1624],  rax
       mov  rax,  qword [rbp-1624]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1632],  rdx
       mov  rax,  qword [rbp-1632]
       imul  rax,  2345
       mov  qword [rbp-1640],  rax
       mov  rax,  qword [rbp-1640]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1648],  rdx
       mov  rax,  qword [rbp-1648]
       imul  rax,  2345
       mov  qword [rbp-1656],  rax
       mov  rax,  qword [rbp-1656]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1664],  rdx
       mov  rax,  qword [rbp-1664]
       imul  rax,  2345
       mov  qword [rbp-1672],  rax
       mov  rax,  qword [rbp-1672]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1680],  rdx
       mov  rax,  qword [rbp-1680]
       imul  rax,  2345
       mov  qword [rbp-1688],  rax
       mov  rax,  qword [rbp-1688]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1696],  rdx
       mov  rax,  qword [rbp-1696]
       imul  rax,  2345
       mov  qword [rbp-1704],  rax
       mov  rax,  qword [rbp-1704]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1712],  rdx
       mov  rax,  qword [rbp-1712]
       imul  rax,  2345
       mov  qword [rbp-1720],  rax
       mov  rax,  qword [rbp-1720]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1728],  rdx
       mov  rax,  qword [rbp-1728]
       imul  rax,  2345
       mov  qword [rbp-1736],  rax
       mov  rax,  qword [rbp-1736]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1744],  rdx
       mov  rax,  qword [rbp-1744]
       imul  rax,  2345
       mov  qword [rbp-1752],  rax
       mov  rax,  qword [rbp-1752]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1760],  rdx
       mov  rax,  qword [rbp-1760]
       imul  rax,  2345
       mov  qword [rbp-1768],  rax
       mov  rax,  qword [rbp-1768]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1776],  rdx
       mov  rax,  qword [rbp-1776]
       imul  rax,  2345
       mov  qword [rbp-1784],  rax
       mov  rax,  qword [rbp-1784]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1792],  rdx
       mov  rax,  qword [rbp-1792]
       imul  rax,  2345
       mov  qword [rbp-1800],  rax
       mov  rax,  qword [rbp-1800]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1808],  rdx
       mov  rax,  qword [rbp-1808]
       imul  rax,  2345
       mov  qword [rbp-1816],  rax
       mov  rax,  qword [rbp-1816]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1824],  rdx
       mov  rax,  qword [rbp-1824]
       imul  rax,  2345
       mov  qword [rbp-1832],  rax
       mov  rax,  qword [rbp-1832]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1840],  rdx
       mov  rax,  qword [rbp-1840]
       imul  rax,  2345
       mov  qword [rbp-1848],  rax
       mov  rax,  qword [rbp-1848]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1856],  rdx
       mov  rax,  qword [rbp-1856]
       imul  rax,  2345
       mov  qword [rbp-1864],  rax
       mov  rax,  qword [rbp-1864]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1872],  rdx
       mov  rax,  qword [rbp-1872]
       imul  rax,  2345
       mov  qword [rbp-1880],  rax
       mov  rax,  qword [rbp-1880]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1888],  rdx
       mov  rax,  qword [rbp-1888]
       imul  rax,  2345
       mov  qword [rbp-1896],  rax
       mov  rax,  qword [rbp-1896]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1904],  rdx
       mov  rax,  qword [rbp-1904]
       imul  rax,  2345
       mov  qword [rbp-1912],  rax
       mov  rax,  qword [rbp-1912]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1920],  rdx
       mov  rax,  qword [rbp-1920]
       imul  rax,  2345
       mov  qword [rbp-1928],  rax
       mov  rax,  qword [rbp-1928]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1936],  rdx
       mov  rax,  qword [rbp-1936]
       imul  rax,  2345
       mov  qword [rbp-1944],  rax
       mov  rax,  qword [rbp-1944]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1952],  rdx
       mov  rax,  qword [rbp-1952]
       imul  rax,  2345
       mov  qword [rbp-1960],  rax
       mov  rax,  qword [rbp-1960]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1968],  rdx
       mov  rax,  qword [rbp-1968]
       imul  rax,  2345
       mov  qword [rbp-1976],  rax
       mov  rax,  qword [rbp-1976]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-1984],  rdx
       mov  rax,  qword [rbp-1984]
       imul  rax,  2345
       mov  qword [rbp-1992],  rax
       mov  rax,  qword [rbp-1992]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-2000],  rdx
       mov  rax,  qword [rbp-2000]
       imul  rax,  2345
       mov  qword [rbp-2008],  rax
       mov  rax,  qword [rbp-2008]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-2016],  rdx
       mov  rax,  qword [rbp-2016]
       imul  rax,  2345
       mov  qword [rbp-2024],  rax
       mov  rax,  qword [rbp-2024]
       mov  rdx,  rax
       mov  rbx,  1234
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-2032],  rdx
       mov  rax,  qword [rbp-2032]
       mov  rdx,  rax
       mov  rbx,  11
       mov  rdx,  0
       idiv  rbx
       mov  qword [rbp-2040],  rdx
       mov  rax,  qword [rbp-376]
       mov  r8,  qword [rbp-2040]
       add  rax,  r8
       mov  qword [rbp-2048],  rax
       mov  rax,  qword [rbp-2048]
       mov  qword [rbp-376],  rax
label30:
       mov  rax,  qword [rbp-368]
       mov  qword [rbp-2056],  rax
       mov  rax,  qword [rbp-368]
       add  rax,  1
       mov  qword [rbp-368],  rax
       jmp  label29
label28:
       mov  rax,  qword [rbp-376]
       mov  rdi,  rax
       call  toString
       mov  qword [rbp-2064],  rax
       mov  rax,  qword [rbp-2064]
       mov  rdi,  rax
       call  println
       mov  qword [rbp-368],  1
label36:
       mov  rbx,  qword [rbp-368]
       cmp  rbx,  200000000
       jg  label39
label38:
       mov  qword [rbp-2072],  1
       jmp  label40
label39:
       mov  qword [rbp-2072],  0
label40:
       mov  rbx,  qword [rbp-2072]
       cmp  rbx,  0
       jz  label35
label34:
label37:
       mov  rax,  qword [rbp-368]
       mov  qword [rbp-2080],  rax
       mov  rax,  qword [rbp-368]
       add  rax,  1
       mov  qword [rbp-368],  rax
       jmp  label36
label35:
       add  rsp,  2096
       pop  rbp
       ret  
__A__A:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  256
       mov  qword [rbp-8],  rdi
       mov  rdi,  24
       call  malloc
       mov  qword [rbp-16],  rax
       mov  rax,  qword [rbp-16]
       mov  qword [rax + 0],  2
       mov  qword [rbp-24],  0
label41:
       mov  rax,  qword [rbp-16]
       mov  rbx,  qword [rbp-24]
       add  rbx,  1
       mov  r8,  qword [rax + rbx * 8]
       mov  qword [rbp-32],  r8
       mov  rdi,  24
       call  malloc
       mov  qword [rbp-32],  rax
       mov  rax,  qword [rbp-32]
       mov  qword [rax + 0],  2
       mov  qword [rbp-40],  0
label43:
       mov  rax,  qword [rbp-32]
       mov  rbx,  qword [rbp-40]
       add  rbx,  1
       mov  r8,  qword [rax + rbx * 8]
       mov  qword [rbp-48],  r8
       mov  rdi,  32
       call  malloc
       mov  qword [rbp-48],  rax
       mov  rax,  qword [rbp-48]
       mov  qword [rax + 0],  3
       mov  qword [rbp-56],  0
label45:
       mov  rax,  qword [rbp-48]
       mov  rbx,  qword [rbp-56]
       add  rbx,  1
       mov  r8,  qword [rax + rbx * 8]
       mov  qword [rbp-64],  r8
       mov  rdi,  24
       call  malloc
       mov  qword [rbp-64],  rax
       mov  rax,  qword [rbp-64]
       mov  qword [rax + 0],  2
       mov  qword [rbp-72],  0
label47:
       mov  rax,  qword [rbp-64]
       mov  rbx,  qword [rbp-72]
       add  rbx,  1
       mov  r8,  qword [rax + rbx * 8]
       mov  qword [rbp-80],  r8
       mov  rdi,  32
       call  malloc
       mov  qword [rbp-80],  rax
       mov  rax,  qword [rbp-80]
       mov  qword [rax + 0],  3
       mov  qword [rbp-88],  0
label49:
       mov  rax,  qword [rbp-80]
       mov  rbx,  qword [rbp-88]
       add  rbx,  1
       mov  r8,  qword [rax + rbx * 8]
       mov  qword [rbp-96],  r8
       mov  rdi,  24
       call  malloc
       mov  qword [rbp-96],  rax
       mov  rax,  qword [rbp-96]
       mov  qword [rax + 0],  2
       mov  qword [rbp-104],  0
label51:
       mov  rax,  qword [rbp-96]
       mov  rbx,  qword [rbp-104]
       add  rbx,  1
       mov  r8,  qword [rax + rbx * 8]
       mov  qword [rbp-112],  r8
       mov  rdi,  24
       call  malloc
       mov  qword [rbp-112],  rax
       mov  rax,  qword [rbp-112]
       mov  qword [rax + 0],  2
       mov  qword [rbp-120],  0
label53:
       mov  rax,  qword [rbp-112]
       mov  rbx,  qword [rbp-120]
       add  rbx,  1
       mov  r8,  qword [rax + rbx * 8]
       mov  qword [rbp-128],  r8
       mov  rdi,  32
       call  malloc
       mov  qword [rbp-128],  rax
       mov  rax,  qword [rbp-128]
       mov  qword [rax + 0],  3
       mov  qword [rbp-136],  0
label55:
       mov  rax,  qword [rbp-128]
       mov  rbx,  qword [rbp-136]
       add  rbx,  1
       mov  r8,  qword [rax + rbx * 8]
       mov  qword [rbp-144],  r8
       mov  rdi,  24
       call  malloc
       mov  qword [rbp-144],  rax
       mov  rax,  qword [rbp-144]
       mov  qword [rax + 0],  2
       mov  qword [rbp-152],  0
label57:
       mov  rax,  qword [rbp-144]
       mov  rbx,  qword [rbp-152]
       add  rbx,  1
       mov  r8,  qword [rax + rbx * 8]
       mov  qword [rbp-160],  r8
       mov  rdi,  24
       call  malloc
       mov  qword [rbp-160],  rax
       mov  rax,  qword [rbp-160]
       mov  qword [rax + 0],  2
       mov  qword [rbp-168],  0
       mov  r8,  qword [rbp-160]
       mov  rax,  qword [rbp-144]
       mov  rbx,  qword [rbp-152]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  rax,  qword [rbp-152]
       add  rax,  1
       mov  qword [rbp-152],  rax
       mov  rbx,  qword [rbp-152]
       cmp  rbx,  2
       jg  label58
       jmp  label57
label58:
       mov  r8,  qword [rbp-144]
       mov  rax,  qword [rbp-128]
       mov  rbx,  qword [rbp-136]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  rax,  qword [rbp-136]
       add  rax,  1
       mov  qword [rbp-136],  rax
       mov  rbx,  qword [rbp-136]
       cmp  rbx,  3
       jg  label56
       jmp  label55
label56:
       mov  r8,  qword [rbp-128]
       mov  rax,  qword [rbp-112]
       mov  rbx,  qword [rbp-120]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  rax,  qword [rbp-120]
       add  rax,  1
       mov  qword [rbp-120],  rax
       mov  rbx,  qword [rbp-120]
       cmp  rbx,  2
       jg  label54
       jmp  label53
label54:
       mov  r8,  qword [rbp-112]
       mov  rax,  qword [rbp-96]
       mov  rbx,  qword [rbp-104]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  rax,  qword [rbp-104]
       add  rax,  1
       mov  qword [rbp-104],  rax
       mov  rbx,  qword [rbp-104]
       cmp  rbx,  2
       jg  label52
       jmp  label51
label52:
       mov  r8,  qword [rbp-96]
       mov  rax,  qword [rbp-80]
       mov  rbx,  qword [rbp-88]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  rax,  qword [rbp-88]
       add  rax,  1
       mov  qword [rbp-88],  rax
       mov  rbx,  qword [rbp-88]
       cmp  rbx,  3
       jg  label50
       jmp  label49
label50:
       mov  r8,  qword [rbp-80]
       mov  rax,  qword [rbp-64]
       mov  rbx,  qword [rbp-72]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  rax,  qword [rbp-72]
       add  rax,  1
       mov  qword [rbp-72],  rax
       mov  rbx,  qword [rbp-72]
       cmp  rbx,  2
       jg  label48
       jmp  label47
label48:
       mov  r8,  qword [rbp-64]
       mov  rax,  qword [rbp-48]
       mov  rbx,  qword [rbp-56]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  rax,  qword [rbp-56]
       add  rax,  1
       mov  qword [rbp-56],  rax
       mov  rbx,  qword [rbp-56]
       cmp  rbx,  3
       jg  label46
       jmp  label45
label46:
       mov  r8,  qword [rbp-48]
       mov  rax,  qword [rbp-32]
       mov  rbx,  qword [rbp-40]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  rax,  qword [rbp-40]
       add  rax,  1
       mov  qword [rbp-40],  rax
       mov  rbx,  qword [rbp-40]
       cmp  rbx,  2
       jg  label44
       jmp  label43
label44:
       mov  r8,  qword [rbp-32]
       mov  rax,  qword [rbp-16]
       mov  rbx,  qword [rbp-24]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  rax,  qword [rbp-24]
       add  rax,  1
       mov  qword [rbp-24],  rax
       mov  rbx,  qword [rbp-24]
       cmp  rbx,  2
       jg  label42
       jmp  label41
label42:
       mov  rbx,  qword [rbp-16]
       mov  rax,  qword [rbp-8]
       mov  qword [rax + 8],  rbx
       add  rsp,  256
       pop  rbp
       ret  
restore:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  64
       mov  qword [rbp-8],  1
label63:
       mov  rbx,  qword [rbp-8]
       mov  r8,  qword[n]
       cmp  rbx,  r8
       jg  label66
label65:
       mov  qword [rbp-16],  1
       jmp  label67
label66:
       mov  qword [rbp-16],  0
label67:
       mov  rbx,  qword [rbp-16]
       cmp  rbx,  0
       jz  label62
label61:
       mov  rax,  qword[a]
       mov  qword [rbp-24],  rax
       mov  rax,  qword[bak]
       mov  qword [rbp-32],  rax
       mov  r8,  qword [rbp-32]
       mov  r9,  qword [rbp-8]
       add  r9,  1
       mov  r10,  qword [r8 + r9 * 8]
       mov  rax,  qword [rbp-24]
       mov  rbx,  qword [rbp-8]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r10
label64:
       mov  rax,  qword [rbp-8]
       mov  qword [rbp-40],  rax
       mov  rax,  qword [rbp-8]
       add  rax,  1
       mov  qword [rbp-8],  rax
       jmp  label63
label62:
       add  rsp,  64
       pop  rbp
       ret  
       add  rsp,  64
       pop  rbp
       ret  
quicksort:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  464
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  qword [rbp-136],  0
       mov  rax,  qword[a]
       mov  qword [rbp-152],  rax
       mov  rax,  qword [rbp-152]
       mov  rbx,  qword [rbp-8]
       add  rbx,  1
       mov  r8,  qword [rax + rbx * 8]
       mov  qword [rbp-144],  r8
       mov  qword [rbp-160],  0
       mov  qword [rbp-168],  0
       mov  rax,  qword [rbp-8]
       add  rax,  1
       mov  qword [rbp-184],  rax
       mov  rax,  qword [rbp-184]
       mov  qword [rbp-176],  rax
label70:
       mov  rbx,  qword [rbp-176]
       mov  r8,  qword [rbp-16]
       cmp  rbx,  r8
       jge  label73
label72:
       mov  qword [rbp-192],  1
       jmp  label74
label73:
       mov  qword [rbp-192],  0
label74:
       mov  rbx,  qword [rbp-192]
       cmp  rbx,  0
       jz  label69
label68:
       mov  rax,  qword [rbp-136]
       mov  qword [rbp-200],  rax
       mov  rax,  qword [rbp-136]
       add  rax,  1
       mov  qword [rbp-136],  rax
       mov  rax,  qword[a]
       mov  qword [rbp-208],  rax
       mov  rbx,  qword [rbp-208]
       mov  r8,  qword [rbp-176]
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  r10,  qword [rbp-144]
       cmp  r9,  r10
       jge  label79
label78:
       mov  qword [rbp-216],  1
       jmp  label80
label79:
       mov  qword [rbp-216],  0
label80:
       mov  rbx,  qword [rbp-216]
       cmp  rbx,  0
       jz  label76
label75:
       mov  rax,  qword [rbp-160]
       mov  qword [rbp-224],  rax
       mov  rax,  qword [rbp-160]
       add  rax,  1
       mov  qword [rbp-160],  rax
       mov  rax,  qword[a_left]
       mov  qword [rbp-232],  rax
       mov  rax,  qword[a]
       mov  qword [rbp-240],  rax
       mov  r8,  qword [rbp-240]
       mov  r9,  qword [rbp-176]
       add  r9,  1
       mov  r10,  qword [r8 + r9 * 8]
       mov  rax,  qword [rbp-232]
       mov  rbx,  qword [rbp-224]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r10
       jmp  label77
label76:
       mov  rax,  qword [rbp-168]
       mov  qword [rbp-248],  rax
       mov  rax,  qword [rbp-168]
       add  rax,  1
       mov  qword [rbp-168],  rax
       mov  rax,  qword[a_right]
       mov  qword [rbp-256],  rax
       mov  rax,  qword[a]
       mov  qword [rbp-264],  rax
       mov  r8,  qword [rbp-264]
       mov  r9,  qword [rbp-176]
       add  r9,  1
       mov  r10,  qword [r8 + r9 * 8]
       mov  rax,  qword [rbp-256]
       mov  rbx,  qword [rbp-248]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r10
       jmp  label77
label77:
label71:
       mov  rax,  qword [rbp-176]
       mov  qword [rbp-272],  rax
       mov  rax,  qword [rbp-176]
       add  rax,  1
       mov  qword [rbp-176],  rax
       jmp  label70
label69:
       mov  rax,  qword [rbp-8]
       mov  qword [rbp-280],  rax
       mov  qword [rbp-176],  0
label83:
       mov  rbx,  qword [rbp-176]
       mov  r8,  qword [rbp-160]
       cmp  rbx,  r8
       jge  label86
label85:
       mov  qword [rbp-288],  1
       jmp  label87
label86:
       mov  qword [rbp-288],  0
label87:
       mov  rbx,  qword [rbp-288]
       cmp  rbx,  0
       jz  label82
label81:
       mov  rax,  qword [rbp-280]
       mov  qword [rbp-296],  rax
       mov  rax,  qword [rbp-280]
       add  rax,  1
       mov  qword [rbp-280],  rax
       mov  rax,  qword[a]
       mov  qword [rbp-304],  rax
       mov  rax,  qword[a_left]
       mov  qword [rbp-312],  rax
       mov  r8,  qword [rbp-312]
       mov  r9,  qword [rbp-176]
       add  r9,  1
       mov  r10,  qword [r8 + r9 * 8]
       mov  rax,  qword [rbp-304]
       mov  rbx,  qword [rbp-296]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r10
label84:
       mov  rax,  qword [rbp-176]
       mov  qword [rbp-320],  rax
       mov  rax,  qword [rbp-176]
       add  rax,  1
       mov  qword [rbp-176],  rax
       jmp  label83
label82:
       mov  rax,  qword [rbp-280]
       mov  qword [rbp-328],  rax
       mov  rax,  qword [rbp-280]
       add  rax,  1
       mov  qword [rbp-280],  rax
       mov  rax,  qword[a]
       mov  qword [rbp-336],  rax
       mov  r8,  qword [rbp-144]
       mov  rax,  qword [rbp-336]
       mov  rbx,  qword [rbp-328]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  qword [rbp-176],  0
label90:
       mov  rbx,  qword [rbp-176]
       mov  r8,  qword [rbp-168]
       cmp  rbx,  r8
       jge  label93
label92:
       mov  qword [rbp-344],  1
       jmp  label94
label93:
       mov  qword [rbp-344],  0
label94:
       mov  rbx,  qword [rbp-344]
       cmp  rbx,  0
       jz  label89
label88:
       mov  rax,  qword [rbp-280]
       mov  qword [rbp-352],  rax
       mov  rax,  qword [rbp-280]
       add  rax,  1
       mov  qword [rbp-280],  rax
       mov  rax,  qword[a]
       mov  qword [rbp-360],  rax
       mov  rax,  qword[a_right]
       mov  qword [rbp-368],  rax
       mov  r8,  qword [rbp-368]
       mov  r9,  qword [rbp-176]
       add  r9,  1
       mov  r10,  qword [r8 + r9 * 8]
       mov  rax,  qword [rbp-360]
       mov  rbx,  qword [rbp-352]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r10
label91:
       mov  rax,  qword [rbp-176]
       mov  qword [rbp-376],  rax
       mov  rax,  qword [rbp-176]
       add  rax,  1
       mov  qword [rbp-176],  rax
       jmp  label90
label89:
       mov  rbx,  qword [rbp-160]
       cmp  rbx,  1
       jle  label99
label98:
       mov  qword [rbp-384],  1
       jmp  label100
label99:
       mov  qword [rbp-384],  0
label100:
       mov  rbx,  qword [rbp-384]
       cmp  rbx,  0
       jz  label96
label95:
       mov  rax,  qword [rbp-8]
       mov  r8,  qword [rbp-160]
       add  rax,  r8
       mov  qword [rbp-400],  rax
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       mov  rax,  qword [rbp-400]
       mov  rsi,  rax
       call  quicksort
       mov  qword [rbp-392],  rax
       mov  rax,  qword [rbp-136]
       mov  r8,  qword [rbp-392]
       add  rax,  r8
       mov  qword [rbp-408],  rax
       mov  rax,  qword [rbp-408]
       mov  qword [rbp-136],  rax
       jmp  label97
label96:
       jmp  label97
label97:
       mov  rbx,  qword [rbp-168]
       cmp  rbx,  1
       jle  label105
label104:
       mov  qword [rbp-416],  1
       jmp  label106
label105:
       mov  qword [rbp-416],  0
label106:
       mov  rbx,  qword [rbp-416]
       cmp  rbx,  0
       jz  label102
label101:
       mov  rax,  qword [rbp-16]
       mov  r8,  qword [rbp-168]
       sub  rax,  r8
       mov  qword [rbp-432],  rax
       mov  rax,  qword [rbp-432]
       mov  rdi,  rax
       mov  rax,  qword [rbp-16]
       mov  rsi,  rax
       call  quicksort
       mov  qword [rbp-424],  rax
       mov  rax,  qword [rbp-136]
       mov  r8,  qword [rbp-424]
       add  rax,  r8
       mov  qword [rbp-440],  rax
       mov  rax,  qword [rbp-440]
       mov  qword [rbp-136],  rax
       jmp  label103
label102:
       jmp  label103
label103:
       mov  rax,  qword [rbp-136]
       add  rsp,  464
       pop  rbp
       ret  
       add  rsp,  464
       pop  rbp
       ret  
calc:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  304
       mov  qword [rbp-120],  1
label109:
       mov  rbx,  qword [rbp-120]
       mov  r8,  qword[n]
       cmp  rbx,  r8
       jg  label112
label111:
       mov  qword [rbp-128],  1
       jmp  label113
label112:
       mov  qword [rbp-128],  0
label113:
       mov  rbx,  qword [rbp-128]
       cmp  rbx,  0
       jz  label108
label107:
       mov  rax,  qword[a_left]
       mov  qword [rbp-136],  rax
       mov  rax,  qword [rbp-120]
       sub  rax,  1
       mov  qword [rbp-144],  rax
       mov  r8,  qword [rbp-144]
       mov  rax,  qword [rbp-136]
       mov  rbx,  qword [rbp-120]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  rax,  qword[a_right]
       mov  qword [rbp-152],  rax
       mov  rax,  qword [rbp-120]
       add  rax,  1
       mov  qword [rbp-160],  rax
       mov  r8,  qword [rbp-160]
       mov  rax,  qword [rbp-152]
       mov  rbx,  qword [rbp-120]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
label110:
       mov  rax,  qword [rbp-120]
       mov  qword [rbp-168],  rax
       mov  rax,  qword [rbp-120]
       add  rax,  1
       mov  qword [rbp-120],  rax
       jmp  label109
label108:
       mov  qword [rbp-176],  0
       mov  rax,  qword[n]
       mov  qword [rbp-120],  rax
label116:
       mov  rbx,  qword [rbp-120]
       cmp  rbx,  1
       jl  label119
label118:
       mov  qword [rbp-184],  1
       jmp  label120
label119:
       mov  qword [rbp-184],  0
label120:
       mov  rbx,  qword [rbp-184]
       cmp  rbx,  0
       jz  label115
label114:
       mov  rax,  qword[a]
       mov  qword [rbp-200],  rax
       mov  rax,  qword[a_left]
       mov  qword [rbp-208],  rax
       mov  rax,  qword [rbp-208]
       mov  r8,  qword [rbp-200]
       mov  r9,  qword [rbp-120]
       add  r9,  1
       mov  rbx,  qword [r8 + r9 * 8]
       add  rbx,  1
       mov  r10,  qword [rax + rbx * 8]
       mov  qword [rbp-192],  r10
       mov  rax,  qword[a]
       mov  qword [rbp-224],  rax
       mov  rax,  qword[a_right]
       mov  qword [rbp-232],  rax
       mov  rax,  qword [rbp-232]
       mov  r8,  qword [rbp-224]
       mov  r9,  qword [rbp-120]
       add  r9,  1
       mov  rbx,  qword [r8 + r9 * 8]
       add  rbx,  1
       mov  r10,  qword [rax + rbx * 8]
       mov  qword [rbp-216],  r10
       mov  rax,  qword[a_right]
       mov  qword [rbp-240],  rax
       mov  r8,  qword [rbp-216]
       mov  rax,  qword [rbp-240]
       mov  rbx,  qword [rbp-192]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  rax,  qword[a_left]
       mov  qword [rbp-248],  rax
       mov  r8,  qword [rbp-192]
       mov  rax,  qword [rbp-248]
       mov  rbx,  qword [rbp-216]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  rax,  qword [rbp-176]
       mov  r8,  qword [rbp-216]
       add  rax,  r8
       mov  qword [rbp-256],  rax
       mov  rax,  qword [rbp-256]
       mov  r8,  qword [rbp-192]
       sub  rax,  r8
       mov  qword [rbp-264],  rax
       mov  rax,  qword [rbp-264]
       sub  rax,  2
       mov  qword [rbp-272],  rax
       mov  rax,  qword [rbp-272]
       mov  qword [rbp-176],  rax
label117:
       mov  rax,  qword [rbp-120]
       mov  qword [rbp-280],  rax
       mov  rax,  qword [rbp-120]
       sub  rax,  1
       mov  qword [rbp-120],  rax
       jmp  label116
label115:
       mov  rax,  qword [rbp-176]
       add  rsp,  304
       pop  rbp
       ret  
       add  rsp,  304
       pop  rbp
       ret  
mergesort:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  560
       mov  qword [rbp-8],  rdi
       mov  qword [rbp-16],  rsi
       mov  rax,  qword [rbp-8]
       add  rax,  1
       mov  qword [rbp-136],  rax
       mov  rbx,  qword [rbp-136]
       mov  r8,  qword [rbp-16]
       cmp  rbx,  r8
       jne  label125
label124:
       mov  qword [rbp-144],  1
       jmp  label126
label125:
       mov  qword [rbp-144],  0
label126:
       mov  rbx,  qword [rbp-144]
       cmp  rbx,  0
       jz  label122
label121:
       mov  rax,  0
       add  rsp,  560
       pop  rbp
       ret  
       jmp  label123
label122:
       jmp  label123
label123:
       mov  rax,  qword [rbp-8]
       mov  r8,  qword [rbp-16]
       add  rax,  r8
       mov  qword [rbp-160],  rax
       mov  rax,  qword [rbp-160]
       mov  rcx,  1
       sar  rax,  cl
       mov  qword [rbp-168],  rax
       mov  rax,  qword [rbp-168]
       mov  qword [rbp-152],  rax
       mov  qword [rbp-176],  0
       mov  rax,  qword [rbp-8]
       mov  rdi,  rax
       mov  rax,  qword [rbp-152]
       mov  rsi,  rax
       call  mergesort
       mov  qword [rbp-184],  rax
       mov  rax,  qword [rbp-176]
       mov  r8,  qword [rbp-184]
       add  rax,  r8
       mov  qword [rbp-192],  rax
       mov  rax,  qword [rbp-192]
       mov  qword [rbp-176],  rax
       mov  rax,  qword [rbp-152]
       mov  rdi,  rax
       mov  rax,  qword [rbp-16]
       mov  rsi,  rax
       call  mergesort
       mov  qword [rbp-200],  rax
       mov  rax,  qword [rbp-176]
       mov  r8,  qword [rbp-200]
       add  rax,  r8
       mov  qword [rbp-208],  rax
       mov  rax,  qword [rbp-208]
       mov  qword [rbp-176],  rax
       mov  qword [rbp-216],  0
       mov  qword [rbp-224],  0
       mov  rax,  qword [rbp-8]
       mov  qword [rbp-232],  rax
label129:
       mov  rbx,  qword [rbp-232]
       mov  r8,  qword [rbp-152]
       cmp  rbx,  r8
       jge  label132
label131:
       mov  qword [rbp-240],  1
       jmp  label133
label132:
       mov  qword [rbp-240],  0
label133:
       mov  rbx,  qword [rbp-240]
       cmp  rbx,  0
       jz  label128
label127:
       mov  rax,  qword [rbp-216]
       mov  qword [rbp-248],  rax
       mov  rax,  qword [rbp-216]
       add  rax,  1
       mov  qword [rbp-216],  rax
       mov  rax,  qword[a_left]
       mov  qword [rbp-256],  rax
       mov  rax,  qword[a]
       mov  qword [rbp-264],  rax
       mov  r8,  qword [rbp-264]
       mov  r9,  qword [rbp-232]
       add  r9,  1
       mov  r10,  qword [r8 + r9 * 8]
       mov  rax,  qword [rbp-256]
       mov  rbx,  qword [rbp-248]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r10
label130:
       mov  rax,  qword [rbp-232]
       mov  qword [rbp-272],  rax
       mov  rax,  qword [rbp-232]
       add  rax,  1
       mov  qword [rbp-232],  rax
       jmp  label129
label128:
       mov  rax,  qword [rbp-152]
       mov  qword [rbp-232],  rax
label136:
       mov  rbx,  qword [rbp-232]
       mov  r8,  qword [rbp-16]
       cmp  rbx,  r8
       jge  label139
label138:
       mov  qword [rbp-280],  1
       jmp  label140
label139:
       mov  qword [rbp-280],  0
label140:
       mov  rbx,  qword [rbp-280]
       cmp  rbx,  0
       jz  label135
label134:
       mov  rax,  qword [rbp-224]
       mov  qword [rbp-288],  rax
       mov  rax,  qword [rbp-224]
       add  rax,  1
       mov  qword [rbp-224],  rax
       mov  rax,  qword[a_right]
       mov  qword [rbp-296],  rax
       mov  rax,  qword[a]
       mov  qword [rbp-304],  rax
       mov  r8,  qword [rbp-304]
       mov  r9,  qword [rbp-232]
       add  r9,  1
       mov  r10,  qword [r8 + r9 * 8]
       mov  rax,  qword [rbp-296]
       mov  rbx,  qword [rbp-288]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r10
label137:
       mov  rax,  qword [rbp-232]
       mov  qword [rbp-312],  rax
       mov  rax,  qword [rbp-232]
       add  rax,  1
       mov  qword [rbp-232],  rax
       jmp  label136
label135:
       mov  qword [rbp-320],  0
       mov  qword [rbp-328],  0
       mov  rax,  qword [rbp-8]
       mov  qword [rbp-336],  rax
label143:
       mov  rbx,  qword [rbp-320]
       mov  r8,  qword [rbp-216]
       cmp  rbx,  r8
       jge  label150
label149:
       mov  qword [rbp-344],  1
       jmp  label151
label150:
       mov  qword [rbp-344],  0
label151:
       mov  rbx,  qword [rbp-344]
       cmp  rbx,  0
       jz  label147
label144:
       mov  rbx,  qword [rbp-328]
       mov  r8,  qword [rbp-224]
       cmp  rbx,  r8
       jge  label153
label152:
       mov  qword [rbp-352],  1
       jmp  label154
label153:
       mov  qword [rbp-352],  0
label154:
       mov  rbx,  qword [rbp-352]
       cmp  rbx,  0
       jz  label147
label146:
       mov  qword [rbp-360],  1
       jmp  label148
label147:
       mov  qword [rbp-360],  0
label148:
       mov  rbx,  qword [rbp-360]
       cmp  rbx,  0
       jz  label142
label141:
       mov  rax,  qword [rbp-176]
       mov  qword [rbp-368],  rax
       mov  rax,  qword [rbp-176]
       add  rax,  1
       mov  qword [rbp-176],  rax
       mov  rax,  qword[a_left]
       mov  qword [rbp-376],  rax
       mov  rax,  qword[a_right]
       mov  qword [rbp-384],  rax
       mov  rbx,  qword [rbp-376]
       mov  r8,  qword [rbp-320]
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  r10,  qword [rbp-384]
       mov  r11,  qword [rbp-328]
       add  r11,  1
       mov  r12,  qword [r10 + r11 * 8]
       cmp  r9,  r12
       jge  label159
label158:
       mov  qword [rbp-392],  1
       jmp  label160
label159:
       mov  qword [rbp-392],  0
label160:
       mov  rbx,  qword [rbp-392]
       cmp  rbx,  0
       jz  label156
label155:
       mov  rax,  qword [rbp-336]
       mov  qword [rbp-400],  rax
       mov  rax,  qword [rbp-336]
       add  rax,  1
       mov  qword [rbp-336],  rax
       mov  rax,  qword[a]
       mov  qword [rbp-408],  rax
       mov  rax,  qword [rbp-320]
       mov  qword [rbp-416],  rax
       mov  rax,  qword [rbp-320]
       add  rax,  1
       mov  qword [rbp-320],  rax
       mov  rax,  qword[a_left]
       mov  qword [rbp-424],  rax
       mov  r8,  qword [rbp-424]
       mov  r9,  qword [rbp-416]
       add  r9,  1
       mov  r10,  qword [r8 + r9 * 8]
       mov  rax,  qword [rbp-408]
       mov  rbx,  qword [rbp-400]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r10
       jmp  label157
label156:
       mov  rax,  qword [rbp-336]
       mov  qword [rbp-432],  rax
       mov  rax,  qword [rbp-336]
       add  rax,  1
       mov  qword [rbp-336],  rax
       mov  rax,  qword[a]
       mov  qword [rbp-440],  rax
       mov  rax,  qword [rbp-328]
       mov  qword [rbp-448],  rax
       mov  rax,  qword [rbp-328]
       add  rax,  1
       mov  qword [rbp-328],  rax
       mov  rax,  qword[a_right]
       mov  qword [rbp-456],  rax
       mov  r8,  qword [rbp-456]
       mov  r9,  qword [rbp-448]
       add  r9,  1
       mov  r10,  qword [r8 + r9 * 8]
       mov  rax,  qword [rbp-440]
       mov  rbx,  qword [rbp-432]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r10
       jmp  label157
label157:
       jmp  label143
label142:
label163:
       mov  rbx,  qword [rbp-320]
       mov  r8,  qword [rbp-216]
       cmp  rbx,  r8
       jge  label165
label164:
       mov  qword [rbp-464],  1
       jmp  label166
label165:
       mov  qword [rbp-464],  0
label166:
       mov  rbx,  qword [rbp-464]
       cmp  rbx,  0
       jz  label162
label161:
       mov  rax,  qword [rbp-336]
       mov  qword [rbp-472],  rax
       mov  rax,  qword [rbp-336]
       add  rax,  1
       mov  qword [rbp-336],  rax
       mov  rax,  qword[a]
       mov  qword [rbp-480],  rax
       mov  rax,  qword [rbp-320]
       mov  qword [rbp-488],  rax
       mov  rax,  qword [rbp-320]
       add  rax,  1
       mov  qword [rbp-320],  rax
       mov  rax,  qword[a_left]
       mov  qword [rbp-496],  rax
       mov  r8,  qword [rbp-496]
       mov  r9,  qword [rbp-488]
       add  r9,  1
       mov  r10,  qword [r8 + r9 * 8]
       mov  rax,  qword [rbp-480]
       mov  rbx,  qword [rbp-472]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r10
       jmp  label163
label162:
label169:
       mov  rbx,  qword [rbp-328]
       mov  r8,  qword [rbp-224]
       cmp  rbx,  r8
       jge  label171
label170:
       mov  qword [rbp-504],  1
       jmp  label172
label171:
       mov  qword [rbp-504],  0
label172:
       mov  rbx,  qword [rbp-504]
       cmp  rbx,  0
       jz  label168
label167:
       mov  rax,  qword [rbp-336]
       mov  qword [rbp-512],  rax
       mov  rax,  qword [rbp-336]
       add  rax,  1
       mov  qword [rbp-336],  rax
       mov  rax,  qword[a]
       mov  qword [rbp-520],  rax
       mov  rax,  qword [rbp-328]
       mov  qword [rbp-528],  rax
       mov  rax,  qword [rbp-328]
       add  rax,  1
       mov  qword [rbp-328],  rax
       mov  rax,  qword[a_right]
       mov  qword [rbp-536],  rax
       mov  r8,  qword [rbp-536]
       mov  r9,  qword [rbp-528]
       add  r9,  1
       mov  r10,  qword [r8 + r9 * 8]
       mov  rax,  qword [rbp-520]
       mov  rbx,  qword [rbp-512]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r10
       jmp  label169
label168:
       mov  rax,  qword [rbp-176]
       add  rsp,  560
       pop  rbp
       ret  
       add  rsp,  560
       pop  rbp
       ret  
heapsort:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  528
       mov  qword [rbp-120],  0
       mov  qword [rbp-128],  1
label175:
       mov  rbx,  qword [rbp-128]
       mov  r8,  qword[n]
       cmp  rbx,  r8
       jg  label178
label177:
       mov  qword [rbp-144],  1
       jmp  label179
label178:
       mov  qword [rbp-144],  0
label179:
       mov  rbx,  qword [rbp-144]
       cmp  rbx,  0
       jz  label174
label173:
       mov  rax,  qword[heap]
       mov  qword [rbp-152],  rax
       mov  rax,  qword[a]
       mov  qword [rbp-160],  rax
       mov  r8,  qword [rbp-160]
       mov  r9,  qword [rbp-128]
       add  r9,  1
       mov  r10,  qword [r8 + r9 * 8]
       mov  rax,  qword [rbp-152]
       mov  rbx,  qword [rbp-128]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r10
       mov  rax,  qword [rbp-128]
       mov  qword [rbp-168],  rax
label182:
       mov  rbx,  qword [rbp-168]
       cmp  rbx,  1
       je  label184
label183:
       mov  qword [rbp-176],  1
       jmp  label185
label184:
       mov  qword [rbp-176],  0
label185:
       mov  rbx,  qword [rbp-176]
       cmp  rbx,  0
       jz  label181
label180:
       mov  rax,  qword [rbp-120]
       mov  qword [rbp-184],  rax
       mov  rax,  qword [rbp-120]
       add  rax,  1
       mov  qword [rbp-120],  rax
       mov  rax,  qword[heap]
       mov  qword [rbp-192],  rax
       mov  rax,  qword [rbp-168]
       mov  rcx,  1
       sar  rax,  cl
       mov  qword [rbp-200],  rax
       mov  rax,  qword[heap]
       mov  qword [rbp-208],  rax
       mov  rbx,  qword [rbp-192]
       mov  r8,  qword [rbp-168]
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  r10,  qword [rbp-208]
       mov  r11,  qword [rbp-200]
       add  r11,  1
       mov  r12,  qword [r10 + r11 * 8]
       cmp  r9,  r12
       jle  label190
label189:
       mov  qword [rbp-216],  1
       jmp  label191
label190:
       mov  qword [rbp-216],  0
label191:
       mov  rbx,  qword [rbp-216]
       cmp  rbx,  0
       jz  label187
label186:
       jmp  label181
       jmp  label188
label187:
       jmp  label188
label188:
       mov  rax,  qword[heap]
       mov  qword [rbp-224],  rax
       mov  rax,  qword [rbp-224]
       mov  rbx,  qword [rbp-168]
       add  rbx,  1
       mov  r8,  qword [rax + rbx * 8]
       mov  qword [rbp-136],  r8
       mov  rax,  qword[heap]
       mov  qword [rbp-232],  rax
       mov  rax,  qword [rbp-168]
       mov  rcx,  1
       sar  rax,  cl
       mov  qword [rbp-240],  rax
       mov  rax,  qword[heap]
       mov  qword [rbp-248],  rax
       mov  r8,  qword [rbp-248]
       mov  r9,  qword [rbp-240]
       add  r9,  1
       mov  r10,  qword [r8 + r9 * 8]
       mov  rax,  qword [rbp-232]
       mov  rbx,  qword [rbp-168]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r10
       mov  rax,  qword [rbp-168]
       mov  rcx,  1
       sar  rax,  cl
       mov  qword [rbp-256],  rax
       mov  rax,  qword[heap]
       mov  qword [rbp-264],  rax
       mov  r8,  qword [rbp-136]
       mov  rax,  qword [rbp-264]
       mov  rbx,  qword [rbp-256]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  rax,  qword [rbp-168]
       mov  rcx,  1
       sar  rax,  cl
       mov  qword [rbp-272],  rax
       mov  rax,  qword [rbp-272]
       mov  qword [rbp-168],  rax
       jmp  label182
label181:
label176:
       mov  rax,  qword [rbp-128]
       mov  qword [rbp-280],  rax
       mov  rax,  qword [rbp-128]
       add  rax,  1
       mov  qword [rbp-128],  rax
       jmp  label175
label174:
       mov  rax,  qword[n]
       mov  qword [rbp-288],  rax
       mov  qword [rbp-128],  1
label194:
       mov  rbx,  qword [rbp-128]
       mov  r8,  qword[n]
       cmp  rbx,  r8
       jg  label197
label196:
       mov  qword [rbp-296],  1
       jmp  label198
label197:
       mov  qword [rbp-296],  0
label198:
       mov  rbx,  qword [rbp-296]
       cmp  rbx,  0
       jz  label193
label192:
       mov  rax,  qword[a]
       mov  qword [rbp-304],  rax
       mov  rax,  qword[heap]
       mov  qword [rbp-312],  rax
       mov  r8,  qword [rbp-312]
       mov  r9,  qword [r8 + 16]
       mov  rax,  qword [rbp-304]
       mov  rbx,  qword [rbp-128]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r9
       mov  rax,  qword[heap]
       mov  qword [rbp-320],  rax
       mov  rax,  qword [rbp-288]
       mov  qword [rbp-328],  rax
       mov  rax,  qword [rbp-288]
       sub  rax,  1
       mov  qword [rbp-288],  rax
       mov  rax,  qword[heap]
       mov  qword [rbp-336],  rax
       mov  rbx,  qword [rbp-336]
       mov  r8,  qword [rbp-328]
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  rax,  qword [rbp-320]
       mov  qword [rax + 16],  r9
       mov  qword [rbp-344],  1
label201:
       mov  rax,  qword [rbp-344]
       mov  rcx,  1
       sal  rax,  cl
       mov  qword [rbp-352],  rax
       mov  rbx,  qword [rbp-352]
       mov  r8,  qword [rbp-288]
       cmp  rbx,  r8
       jg  label203
label202:
       mov  qword [rbp-360],  1
       jmp  label204
label203:
       mov  qword [rbp-360],  0
label204:
       mov  rbx,  qword [rbp-360]
       cmp  rbx,  0
       jz  label200
label199:
       mov  rax,  qword [rbp-344]
       mov  rcx,  1
       sal  rax,  cl
       mov  qword [rbp-376],  rax
       mov  rax,  qword [rbp-376]
       mov  qword [rbp-368],  rax
       mov  rax,  qword [rbp-368]
       add  rax,  1
       mov  qword [rbp-392],  rax
       mov  rax,  qword [rbp-392]
       mov  qword [rbp-384],  rax
       mov  rax,  qword [rbp-368]
       mov  qword [rbp-400],  rax
       mov  rbx,  qword [rbp-384]
       mov  r8,  qword [rbp-288]
       cmp  rbx,  r8
       jg  label209
label208:
       mov  qword [rbp-408],  1
       jmp  label210
label209:
       mov  qword [rbp-408],  0
label210:
       mov  rbx,  qword [rbp-408]
       cmp  rbx,  0
       jz  label206
label205:
       mov  rax,  qword [rbp-120]
       mov  qword [rbp-416],  rax
       mov  rax,  qword [rbp-120]
       add  rax,  1
       mov  qword [rbp-120],  rax
       mov  rax,  qword[heap]
       mov  qword [rbp-424],  rax
       mov  rax,  qword[heap]
       mov  qword [rbp-432],  rax
       mov  rbx,  qword [rbp-424]
       mov  r8,  qword [rbp-384]
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  r10,  qword [rbp-432]
       mov  r11,  qword [rbp-368]
       add  r11,  1
       mov  r12,  qword [r10 + r11 * 8]
       cmp  r9,  r12
       jge  label215
label214:
       mov  qword [rbp-440],  1
       jmp  label216
label215:
       mov  qword [rbp-440],  0
label216:
       mov  rbx,  qword [rbp-440]
       cmp  rbx,  0
       jz  label212
label211:
       mov  rax,  qword [rbp-384]
       mov  qword [rbp-400],  rax
       jmp  label213
label212:
       jmp  label213
label213:
       jmp  label207
label206:
       jmp  label207
label207:
       mov  rax,  qword [rbp-120]
       mov  qword [rbp-448],  rax
       mov  rax,  qword [rbp-120]
       add  rax,  1
       mov  qword [rbp-120],  rax
       mov  rax,  qword[heap]
       mov  qword [rbp-456],  rax
       mov  rax,  qword[heap]
       mov  qword [rbp-464],  rax
       mov  rbx,  qword [rbp-456]
       mov  r8,  qword [rbp-344]
       add  r8,  1
       mov  r9,  qword [rbx + r8 * 8]
       mov  r10,  qword [rbp-464]
       mov  r11,  qword [rbp-400]
       add  r11,  1
       mov  r12,  qword [r10 + r11 * 8]
       cmp  r9,  r12
       jge  label221
label220:
       mov  qword [rbp-472],  1
       jmp  label222
label221:
       mov  qword [rbp-472],  0
label222:
       mov  rbx,  qword [rbp-472]
       cmp  rbx,  0
       jz  label218
label217:
       jmp  label200
       jmp  label219
label218:
       jmp  label219
label219:
       mov  rax,  qword[heap]
       mov  qword [rbp-480],  rax
       mov  rax,  qword [rbp-480]
       mov  rbx,  qword [rbp-344]
       add  rbx,  1
       mov  r8,  qword [rax + rbx * 8]
       mov  qword [rbp-136],  r8
       mov  rax,  qword[heap]
       mov  qword [rbp-488],  rax
       mov  rax,  qword[heap]
       mov  qword [rbp-496],  rax
       mov  r8,  qword [rbp-496]
       mov  r9,  qword [rbp-400]
       add  r9,  1
       mov  r10,  qword [r8 + r9 * 8]
       mov  rax,  qword [rbp-488]
       mov  rbx,  qword [rbp-344]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r10
       mov  rax,  qword[heap]
       mov  qword [rbp-504],  rax
       mov  r8,  qword [rbp-136]
       mov  rax,  qword [rbp-504]
       mov  rbx,  qword [rbp-400]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  rax,  qword [rbp-344]
       mov  qword [rbp-136],  rax
       mov  rax,  qword [rbp-400]
       mov  qword [rbp-344],  rax
       mov  rax,  qword [rbp-136]
       mov  qword [rbp-400],  rax
       jmp  label201
label200:
label195:
       mov  rax,  qword [rbp-128]
       mov  qword [rbp-512],  rax
       mov  rax,  qword [rbp-128]
       add  rax,  1
       mov  qword [rbp-128],  rax
       jmp  label194
label193:
       mov  rax,  qword [rbp-120]
       add  rsp,  528
       pop  rbp
       ret  
       add  rsp,  528
       pop  rbp
       ret  
main:
       push  rbp
       mov  rbp,  rsp
       sub  rsp,  368
       mov  rbx,  qword[N]
       mov  r15,  rbx
       add  r15,  1
       imul  r15,  8
       mov  rdi,  r15
       call  malloc
       mov  qword [rbp-8],  rax
       mov  rbx,  qword[N]
       mov  rax,  qword [rbp-8]
       mov  qword [rax + 0],  rbx
       mov  rax,  qword [rbp-8]
       mov  qword[a],  rax
       mov  rbx,  qword[N]
       mov  r15,  rbx
       add  r15,  1
       imul  r15,  8
       mov  rdi,  r15
       call  malloc
       mov  qword [rbp-16],  rax
       mov  rbx,  qword[N]
       mov  rax,  qword [rbp-16]
       mov  qword [rax + 0],  rbx
       mov  rax,  qword [rbp-16]
       mov  qword[bak],  rax
       mov  rbx,  qword[N]
       mov  r15,  rbx
       add  r15,  1
       imul  r15,  8
       mov  rdi,  r15
       call  malloc
       mov  qword [rbp-24],  rax
       mov  rbx,  qword[N]
       mov  rax,  qword [rbp-24]
       mov  qword [rax + 0],  rbx
       mov  rax,  qword [rbp-24]
       mov  qword[a_left],  rax
       mov  rbx,  qword[N]
       mov  r15,  rbx
       add  r15,  1
       imul  r15,  8
       mov  rdi,  r15
       call  malloc
       mov  qword [rbp-32],  rax
       mov  rbx,  qword[N]
       mov  rax,  qword [rbp-32]
       mov  qword [rax + 0],  rbx
       mov  rax,  qword [rbp-32]
       mov  qword[a_right],  rax
       mov  rbx,  qword[N]
       mov  r15,  rbx
       add  r15,  1
       imul  r15,  8
       mov  rdi,  r15
       call  malloc
       mov  qword [rbp-40],  rax
       mov  rbx,  qword[N]
       mov  rax,  qword [rbp-40]
       mov  qword [rax + 0],  rbx
       mov  rax,  qword [rbp-40]
       mov  qword[heap],  rax
       call  getInt
       mov  qword [rbp-120],  rax
       mov  rax,  qword [rbp-120]
       mov  qword[n],  rax
       call  getInt
       mov  qword [rbp-136],  rax
       mov  rax,  qword [rbp-136]
       mov  qword [rbp-128],  rax
       mov  qword [rbp-144],  1
label225:
       mov  rbx,  qword [rbp-144]
       mov  r8,  qword[n]
       cmp  rbx,  r8
       jg  label228
label227:
       mov  qword [rbp-152],  1
       jmp  label229
label228:
       mov  qword [rbp-152],  0
label229:
       mov  rbx,  qword [rbp-152]
       cmp  rbx,  0
       jz  label224
label223:
       mov  rax,  qword[a]
       mov  qword [rbp-160],  rax
       mov  r8,  qword [rbp-144]
       mov  rax,  qword [rbp-160]
       mov  rbx,  qword [rbp-144]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       mov  rbx,  qword [rbp-144]
       mov  r8,  qword [rbp-128]
       cmp  rbx,  r8
       jg  label234
label233:
       mov  qword [rbp-168],  1
       jmp  label235
label234:
       mov  qword [rbp-168],  0
label235:
       mov  rbx,  qword [rbp-168]
       cmp  rbx,  0
       jz  label231
label230:
       mov  rax,  qword[a]
       mov  qword [rbp-176],  rax
       mov  rax,  qword [rbp-128]
       add  rax,  1
       mov  qword [rbp-184],  rax
       mov  rax,  qword [rbp-184]
       mov  r8,  qword [rbp-144]
       sub  rax,  r8
       mov  qword [rbp-192],  rax
       mov  r8,  qword [rbp-192]
       mov  rax,  qword [rbp-176]
       mov  rbx,  qword [rbp-144]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r8
       jmp  label232
label231:
       jmp  label232
label232:
       mov  rax,  qword[bak]
       mov  qword [rbp-200],  rax
       mov  rax,  qword[a]
       mov  qword [rbp-208],  rax
       mov  r8,  qword [rbp-208]
       mov  r9,  qword [rbp-144]
       add  r9,  1
       mov  r10,  qword [r8 + r9 * 8]
       mov  rax,  qword [rbp-200]
       mov  rbx,  qword [rbp-144]
       add  rbx,  1
       mov  qword [rax + rbx * 8],  r10
label226:
       mov  rax,  qword [rbp-144]
       mov  qword [rbp-216],  rax
       mov  rax,  qword [rbp-144]
       add  rax,  1
       mov  qword [rbp-144],  rax
       jmp  label225
label224:
       mov  rax,  qword[n]
       add  rax,  1
       mov  qword [rbp-240],  rax
       mov  rdi,  1
       mov  rax,  qword [rbp-240]
       mov  rsi,  rax
       call  quicksort
       mov  qword [rbp-232],  rax
       mov  rax,  qword [rbp-232]
       mov  qword [rbp-224],  rax
       call  restore
       call  calc
       mov  qword [rbp-256],  rax
       mov  rax,  qword [rbp-256]
       mov  qword [rbp-248],  rax
       call  restore
       mov  rax,  qword[n]
       add  rax,  1
       mov  qword [rbp-280],  rax
       mov  rdi,  1
       mov  rax,  qword [rbp-280]
       mov  rsi,  rax
       call  mergesort
       mov  qword [rbp-272],  rax
       mov  rax,  qword [rbp-272]
       mov  qword [rbp-264],  rax
       call  restore
       call  heapsort
       mov  qword [rbp-296],  rax
       mov  rax,  qword [rbp-296]
       mov  qword [rbp-288],  rax
       mov  rax,  qword [rbp-224]
       mov  rdi,  rax
       call  toString
       mov  qword [rbp-304],  rax
       mov  rax,  qword [rbp-304]
       mov  rdi,  rax
       call  println
       mov  rax,  qword [rbp-248]
       mov  rdi,  rax
       call  toString
       mov  qword [rbp-312],  rax
       mov  rax,  qword [rbp-312]
       mov  rdi,  rax
       call  println
       mov  rax,  qword [rbp-264]
       mov  rdi,  rax
       call  toString
       mov  qword [rbp-320],  rax
       mov  rax,  qword [rbp-320]
       mov  rdi,  rax
       call  println
       mov  rax,  qword [rbp-288]
       mov  rdi,  rax
       call  toString
       mov  qword [rbp-328],  rax
       mov  rax,  qword [rbp-328]
       mov  rdi,  rax
       call  println
       mov  rdi,  72
       call  malloc
       mov  qword [rbp-344],  rax
       mov  rax,  qword [rbp-344]
       mov  qword [rbp-336],  rax
       mov  rax,  qword [rbp-336]
       mov  rdi,  rax
       call  __A__Optimizer
       mov  rax,  0
       add  rsp,  368
       pop  rbp
       ret  
       add  rsp,  368
       pop  rbp
       ret  

section .data
N:
       dq  100000

section .bss

n:       resq  1
a:       resq  1
bak:       resq  1
a_left:       resq  1
a_right:       resq  1
heap:       resq  1
i1:       resq  1
i2:       resq  1
i3:       resq  1
i4:       resq  1
i5:       resq  1
i6:       resq  1
i7:       resq  1
i8:       resq  1
i9:       resq  1
i10:       resq  1
i11:       resq  1
i12:       resq  1
i13:       resq  1
i14:       resq  1


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
