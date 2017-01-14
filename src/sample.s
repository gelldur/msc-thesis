main:                                   # @main for ARM architecture
        push    rbp
        mov     rbp, rsp
        mov     dword ptr [rbp - 4], 0
        mov     dword ptr [rbp - 8], 2
        mov     eax, dword ptr [rbp - 8]
        add     eax, 4
        mov     dword ptr [rbp - 8], eax
        mov     eax, dword ptr [rbp - 8]
        pop     rbp
        ret
