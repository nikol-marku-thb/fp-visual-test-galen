
 @objects
    body                     css   body
    header                   id    top-nav
      header-logo            id    header-logo   # TODO

    menu                     css   #sidebar
      menu-item-*            css   ul li a
    content                  id    main-content
    footer                   id    footer              # TODO


 = Profile Page =
    @on desktop
        body:
          image file images/base/profile-1360.png, error 4%, stretch, analyze-offset 10, tolerance 80
        header:
          image file images/base/profile-header-1360.png, error 4%, stretch, analyze-offset 10, tolerance 80
        content:
          image file images/base/profile-content-1360.png, error 4%, stretch, analyze-offset 10, tolerance 80