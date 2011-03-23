import re

text = '''



<span dir="ltr" class="yt-uix-button-group addto-container short video-actions" data-video-ids="kffacxfA7G4" data-feature="thumbnail"><button type="button" class="master-sprite start yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-action="yt.www.addtomenu.add" role="button" aria-pressed="false"><img class="yt-uix-button-icon-addto" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""> <span class="yt-uix-button-content"><span class="addto-label">Adicionar a</span></span></button><button type="button" class="end yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-menu-id="shared-addto-menu" data-button-action="" role="button" aria-pressed="false"> <img class="yt-uix-button-arrow" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""></button></span>
<span class="video-in-quicklist">Adicionado à fila     </span></a>
    
    <div class="video-details">
      <h3 class="chart-rank-title">
        <span class="rank">1</span>
        <a href="/watch?v=kffacxfA7G4" class="video-title" title="Justin Bieber - Baby ft. Ludacris" dir="ltr">Justin Bieber - Baby ft. Ludacris</a>
      </h3>
      <p class="description">
        Music video by Justin Bieber performing Baby.
      </p>
      <ul class="facets">
        <li>  <span class="video-username">
por <a title="JustinBieberVEVO" href="/user/JustinBieberVEVO">JustinBieberVEVO</a>
  </span>
</li>
        <li>há 10 meses</li>
        <li class="last"><strong>411826999 visualizações
</strong></li>
      </ul>
    </div>
  </li>

      <li>
    
  




  


    

<a href="/watch?v=qrO4YZeyl0I" class="ux-thumb-wrap contains-addto"><span class="video-thumb ux-thumb-128 "><span class="clip"><img src="http://i2.ytimg.com/vi/qrO4YZeyl0I/default.jpg" class="" title="Lady Gaga - Bad Romance" ></span></span><span class="video-time">5:08</span>  





<span dir="ltr" class="yt-uix-button-group addto-container short video-actions" data-video-ids="qrO4YZeyl0I" data-feature="thumbnail"><button type="button" class="master-sprite start yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-action="yt.www.addtomenu.add" role="button" aria-pressed="false"><img class="yt-uix-button-icon-addto" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""> <span class="yt-uix-button-content"><span class="addto-label">Adicionar a</span></span></button><button type="button" class="end yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-menu-id="shared-addto-menu" data-button-action="" role="button" aria-pressed="false"> <img class="yt-uix-button-arrow" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""></button></span>
<span class="video-in-quicklist">Adicionado à fila     </span></a>
    
    <div class="video-details">
      <h3 class="chart-rank-title">
        <span class="rank">2</span>
        <a href="/watch?v=qrO4YZeyl0I" class="video-title" title="Lady Gaga - Bad Romance" dir="ltr">Lady Gaga - Bad Romance</a>
      </h3>
      <p class="description">
        Music video by Lady Gaga performing Bad Romance...
      </p>
      <ul class="facets">
        <li>  <span class="video-username">
por <a title="LadyGagaVEVO" href="/user/LadyGagaVEVO">LadyGagaVEVO</a>
  </span>
</li>
        <li>há 1 ano</li>
        <li class="last"><strong>319684779 visualizações
</strong></li>
      </ul>
    </div>
  </li>

      <li>
    
  




  


    

<a href="/watch?v=_OBlgSz8sSM" class="ux-thumb-wrap contains-addto"><span class="video-thumb ux-thumb-128 "><span class="clip"><img src="http://i4.ytimg.com/vi/_OBlgSz8sSM/default.jpg" class="" title="Charlie bit my finger - again !" ></span></span><span class="video-time">0:56</span>  





<span dir="ltr" class="yt-uix-button-group addto-container short video-actions" data-video-ids="_OBlgSz8sSM" data-feature="thumbnail"><button type="button" class="master-sprite start yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-action="yt.www.addtomenu.add" role="button" aria-pressed="false"><img class="yt-uix-button-icon-addto" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""> <span class="yt-uix-button-content"><span class="addto-label">Adicionar a</span></span></button><button type="button" class="end yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-menu-id="shared-addto-menu" data-button-action="" role="button" aria-pressed="false"> <img class="yt-uix-button-arrow" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""></button></span>
<span class="video-in-quicklist">Adicionado à fila     </span></a>
    
    <div class="video-details">
      <h3 class="chart-rank-title">
        <span class="rank">3</span>
        <a href="/watch?v=_OBlgSz8sSM" class="video-title" title="Charlie bit my finger - again !" dir="ltr">Charlie bit my finger - again !</a>
      </h3>
      <p class="description">
        Even had I thought of trying to get my boys to ...
      </p>
      <ul class="facets">
        <li>  <span class="video-username">
por <a title="HDCYT" href="/user/HDCYT">HDCYT</a>
  </span>
</li>
        <li>há 3 anos</li>
        <li class="last"><strong>259608100 visualizações
</strong></li>
      </ul>
    </div>
  </li>

      <li>
    
  




  


    

<a href="/watch?v=pRpeEdMmmQ0" class="ux-thumb-wrap contains-addto"><span class="video-thumb ux-thumb-128 "><span class="clip"><img src="http://i1.ytimg.com/vi/pRpeEdMmmQ0/default.jpg" class="" title="Shakira ft. Freshlyground - Waka Waka (This Time for Africa) (The Official 2010 FIFA World Cup Song)" ></span></span><span class="video-time">3:31</span>  





<span dir="ltr" class="yt-uix-button-group addto-container short video-actions" data-video-ids="pRpeEdMmmQ0" data-feature="thumbnail"><button type="button" class="master-sprite start yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-action="yt.www.addtomenu.add" role="button" aria-pressed="false"><img class="yt-uix-button-icon-addto" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""> <span class="yt-uix-button-content"><span class="addto-label">Adicionar a</span></span></button><button type="button" class="end yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-menu-id="shared-addto-menu" data-button-action="" role="button" aria-pressed="false"> <img class="yt-uix-button-arrow" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""></button></span>
<span class="video-in-quicklist">Adicionado à fila     </span></a>
    
    <div class="video-details">
      <h3 class="chart-rank-title">
        <span class="rank">4</span>
        <a href="/watch?v=pRpeEdMmmQ0" class="video-title" title="Shakira ft. Freshlyground - Waka Waka (This Time for Africa) (The Official 2010 FIFA World Cup Song)" dir="ltr">Shakira ft. Freshlyground - Waka Waka (This Tim...</a>
      </h3>
      <p class="description">
        Music video by Shakira featuring Freshlyground ...
      </p>
      <ul class="facets">
        <li>  <span class="video-username">
por <a title="shakiraVEVO" href="/user/shakiraVEVO">shakiraVEVO</a>
  </span>
</li>
        <li>há 6 meses</li>
        <li class="last"><strong>258508839 visualizações
</strong></li>
      </ul>
    </div>
  </li>

      <li>
    
  




  


    

<a href="/watch?v=uelHwf8o7_U" class="ux-thumb-wrap contains-addto"><span class="video-thumb ux-thumb-128 "><span class="clip"><img src="http://i2.ytimg.com/vi/uelHwf8o7_U/default.jpg" class="" title="Eminem - Love The Way You Lie ft. Rihanna" ></span></span><span class="video-time">4:27</span>  





<span dir="ltr" class="yt-uix-button-group addto-container short video-actions" data-video-ids="uelHwf8o7_U" data-feature="thumbnail"><button type="button" class="master-sprite start yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-action="yt.www.addtomenu.add" role="button" aria-pressed="false"><img class="yt-uix-button-icon-addto" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""> <span class="yt-uix-button-content"><span class="addto-label">Adicionar a</span></span></button><button type="button" class="end yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-menu-id="shared-addto-menu" data-button-action="" role="button" aria-pressed="false"> <img class="yt-uix-button-arrow" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""></button></span>
<span class="video-in-quicklist">Adicionado à fila     </span></a>
    
    <div class="video-details">
      <h3 class="chart-rank-title">
        <span class="rank">5</span>
        <a href="/watch?v=uelHwf8o7_U" class="video-title" title="Eminem - Love The Way You Lie ft. Rihanna" dir="ltr">Eminem - Love The Way You Lie ft. Rihanna</a>
      </h3>
      <p class="description">
        Music video by Eminem performing Love The Way Y...
      </p>
      <ul class="facets">
        <li>  <span class="video-username">
por <a title="EminemVEVO" href="/user/EminemVEVO">EminemVEVO</a>
  </span>
</li>
        <li>há 4 meses</li>
        <li class="last"><strong>237093181 visualizações
</strong></li>
      </ul>
    </div>
  </li>

      <li>
    
  




  


    

<a href="/watch?v=M11SvDtPBhA" class="ux-thumb-wrap contains-addto"><span class="video-thumb ux-thumb-128 "><span class="clip"><img src="http://i2.ytimg.com/vi/M11SvDtPBhA/default.jpg" class="" title="Miley Cyrus - Party In The U.S.A." ></span></span><span class="video-time">3:21</span>  





<span dir="ltr" class="yt-uix-button-group addto-container short video-actions" data-video-ids="M11SvDtPBhA" data-feature="thumbnail"><button type="button" class="master-sprite start yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-action="yt.www.addtomenu.add" role="button" aria-pressed="false"><img class="yt-uix-button-icon-addto" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""> <span class="yt-uix-button-content"><span class="addto-label">Adicionar a</span></span></button><button type="button" class="end yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-menu-id="shared-addto-menu" data-button-action="" role="button" aria-pressed="false"> <img class="yt-uix-button-arrow" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""></button></span>
<span class="video-in-quicklist">Adicionado à fila     </span></a>
    
    <div class="video-details">
      <h3 class="chart-rank-title">
        <span class="rank">6</span>
        <a href="/watch?v=M11SvDtPBhA" class="video-title" title="Miley Cyrus - Party In The U.S.A." dir="ltr">Miley Cyrus - Party In The U.S.A.</a>
      </h3>
      <p class="description">
        Music video by Miley Cyrus performing Party In ...
      </p>
      <ul class="facets">
        <li>  <span class="video-username">
por <a title="hollywoodrecords" href="/user/hollywoodrecords">hollywoodrecords</a>
  </span>
</li>
        <li>há 1 ano</li>
        <li class="last"><strong>180222961 visualizações
</strong></li>
      </ul>
    </div>
  </li>

      <li>
    
  




  


    

<a href="/watch?v=j5-yKhDd64s" class="ux-thumb-wrap contains-addto"><span class="video-thumb ux-thumb-128 "><span class="clip"><img src="http://i3.ytimg.com/vi/j5-yKhDd64s/default.jpg" class="" title="Eminem - Not Afraid" ></span></span><span class="video-time">4:19</span>  





<span dir="ltr" class="yt-uix-button-group addto-container short video-actions" data-video-ids="j5-yKhDd64s" data-feature="thumbnail"><button type="button" class="master-sprite start yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-action="yt.www.addtomenu.add" role="button" aria-pressed="false"><img class="yt-uix-button-icon-addto" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""> <span class="yt-uix-button-content"><span class="addto-label">Adicionar a</span></span></button><button type="button" class="end yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-menu-id="shared-addto-menu" data-button-action="" role="button" aria-pressed="false"> <img class="yt-uix-button-arrow" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""></button></span>
<span class="video-in-quicklist">Adicionado à fila     </span></a>
    
    <div class="video-details">
      <h3 class="chart-rank-title">
        <span class="rank">7</span>
        <a href="/watch?v=j5-yKhDd64s" class="video-title" title="Eminem - Not Afraid" dir="ltr">Eminem - Not Afraid</a>
      </h3>
      <p class="description">
        Music video by Eminem performing Not Afraid. (C...
      </p>
      <ul class="facets">
        <li>  <span class="video-username">
por <a title="EminemVEVO" href="/user/EminemVEVO">EminemVEVO</a>
  </span>
</li>
        <li>há 6 meses</li>
        <li class="last"><strong>168513213 visualizações
</strong></li>
      </ul>
    </div>
  </li>

      <li>
    
  




  


    

<a href="/watch?v=dMH0bHeiRNg" class="ux-thumb-wrap contains-addto"><span class="video-thumb ux-thumb-128 "><span class="clip"><img src="http://i1.ytimg.com/vi/dMH0bHeiRNg/default.jpg" class="" title="Evolution of Dance - By Judson Laipply" ></span></span><span class="video-time">6:00</span>  





<span dir="ltr" class="yt-uix-button-group addto-container short video-actions" data-video-ids="dMH0bHeiRNg" data-feature="thumbnail"><button type="button" class="master-sprite start yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-action="yt.www.addtomenu.add" role="button" aria-pressed="false"><img class="yt-uix-button-icon-addto" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""> <span class="yt-uix-button-content"><span class="addto-label">Adicionar a</span></span></button><button type="button" class="end yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-menu-id="shared-addto-menu" data-button-action="" role="button" aria-pressed="false"> <img class="yt-uix-button-arrow" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""></button></span>
<span class="video-in-quicklist">Adicionado à fila     </span></a>
    
    <div class="video-details">
      <h3 class="chart-rank-title">
        <span class="rank">8</span>
        <a href="/watch?v=dMH0bHeiRNg" class="video-title" title="Evolution of Dance - By Judson Laipply" dir="ltr">Evolution of Dance - By Judson Laipply</a>
      </h3>
      <p class="description">
        For more visit http://www.mightaswelldance.com
      </p>
      <ul class="facets">
        <li>  <span class="video-username">
por <a title="judsonlaipply" href="/user/judsonlaipply">judsonlaipply</a>
  </span>
</li>
        <li>há 4 anos</li>
        <li class="last"><strong>159010795 visualizações
</strong></li>
      </ul>
    </div>
  </li>

      <li>
    
  




  


    

<a href="/watch?v=E2tMV96xULk" class="ux-thumb-wrap contains-addto"><span class="video-thumb ux-thumb-128 "><span class="clip"><img src="http://i2.ytimg.com/vi/E2tMV96xULk/default.jpg" class="" title="Pitbull - I Know You Want Me (Calle Ocho) OFFICIAL VIDEO" ></span></span><span class="video-time">4:06</span>  





<span dir="ltr" class="yt-uix-button-group addto-container short video-actions" data-video-ids="E2tMV96xULk" data-feature="thumbnail"><button type="button" class="master-sprite start yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-action="yt.www.addtomenu.add" role="button" aria-pressed="false"><img class="yt-uix-button-icon-addto" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""> <span class="yt-uix-button-content"><span class="addto-label">Adicionar a</span></span></button><button type="button" class="end yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-menu-id="shared-addto-menu" data-button-action="" role="button" aria-pressed="false"> <img class="yt-uix-button-arrow" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""></button></span>
<span class="video-in-quicklist">Adicionado à fila     </span></a>
    
    <div class="video-details">
      <h3 class="chart-rank-title">
        <span class="rank">9</span>
        <a href="/watch?v=E2tMV96xULk" class="video-title" title="Pitbull - I Know You Want Me (Calle Ocho) OFFICIAL VIDEO" dir="ltr">Pitbull - I Know You Want Me (Calle Ocho) OFFIC...</a>
      </h3>
      <p class="description">
        Get Your 'I Know You Want Me' t-shirts here: ht...
      </p>
      <ul class="facets">
        <li>  <span class="video-username">
por <a title="UltraRecords" href="/user/UltraRecords">UltraRecords</a>
  </span>
</li>
        <li>há 1 ano</li>
        <li class="last"><strong>156024419 visualizações
</strong></li>
      </ul>
    </div>
  </li>

      <li>
    
  




  


    

<a href="/watch?v=5P6UU6m3cqk" class="ux-thumb-wrap contains-addto"><span class="video-thumb ux-thumb-128 "><span class="clip"><img src="http://i2.ytimg.com/vi/5P6UU6m3cqk/default.jpg" class="" title="Hahaha" ></span></span><span class="video-time">1:40</span>  





<span dir="ltr" class="yt-uix-button-group addto-container short video-actions" data-video-ids="5P6UU6m3cqk" data-feature="thumbnail"><button type="button" class="master-sprite start yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-action="yt.www.addtomenu.add" role="button" aria-pressed="false"><img class="yt-uix-button-icon-addto" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""> <span class="yt-uix-button-content"><span class="addto-label">Adicionar a</span></span></button><button type="button" class="end yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-menu-id="shared-addto-menu" data-button-action="" role="button" aria-pressed="false"> <img class="yt-uix-button-arrow" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""></button></span>
<span class="video-in-quicklist">Adicionado à fila     </span></a>
    
    <div class="video-details">
      <h3 class="chart-rank-title">
        <span class="rank">10</span>
        <a href="/watch?v=5P6UU6m3cqk" class="video-title" title="Hahaha" dir="ltr">Hahaha</a>
      </h3>
      <p class="description">
        Small daring boy
      </p>
      <ul class="facets">
        <li>  <span class="video-username">
por <a title="BlackOleg" href="/user/BlackOleg">BlackOleg</a>
  </span>
</li>
        <li>há 4 anos</li>
        <li class="last"><strong>150876573 visualizações
</strong></li>
      </ul>
    </div>
  </li>

      <li>
    
  




  


    

<a href="/watch?v=6Jlv8F9cerA" class="ux-thumb-wrap contains-addto"><span class="video-thumb ux-thumb-128 "><span class="clip"><img src="http://i3.ytimg.com/vi/6Jlv8F9cerA/default.jpg" class="" title="An experiment" ></span></span><span class="video-time">0:25</span>  





<span dir="ltr" class="yt-uix-button-group addto-container short video-actions" data-video-ids="6Jlv8F9cerA" data-feature="thumbnail"><button type="button" class="master-sprite start yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-action="yt.www.addtomenu.add" role="button" aria-pressed="false"><img class="yt-uix-button-icon-addto" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""> <span class="yt-uix-button-content"><span class="addto-label">Adicionar a</span></span></button><button type="button" class="end yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-menu-id="shared-addto-menu" data-button-action="" role="button" aria-pressed="false"> <img class="yt-uix-button-arrow" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""></button></span>
<span class="video-in-quicklist">Adicionado à fila     </span></a>
    
    <div class="video-details">
      <h3 class="chart-rank-title">
        <span class="rank">11</span>
        <a href="/watch?v=6Jlv8F9cerA" class="video-title" title="An experiment" dir="ltr">An experiment</a>
      </h3>
      <p class="description">
        Please listen to my songs on iTune!!

http://ph...
      </p>
      <ul class="facets">
        <li>  <span class="video-username">
por <a title="294tv" href="/user/294tv">294tv</a>
  </span>
</li>
        <li>há 2 anos</li>
        <li class="last"><strong>140595772 visualizações
</strong></li>
      </ul>
    </div>
  </li>

      <li>
    
  




  


    

<a href="/watch?v=Hr0Wv5DJhuk" class="ux-thumb-wrap contains-addto"><span class="video-thumb ux-thumb-128 "><span class="clip"><img src="http://i1.ytimg.com/vi/Hr0Wv5DJhuk/default.jpg" class="" title="Miley Cyrus - 7 Things" ></span></span><span class="video-time">3:40</span>  





<span dir="ltr" class="yt-uix-button-group addto-container short video-actions" data-video-ids="Hr0Wv5DJhuk" data-feature="thumbnail"><button type="button" class="master-sprite start yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-action="yt.www.addtomenu.add" role="button" aria-pressed="false"><img class="yt-uix-button-icon-addto" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""> <span class="yt-uix-button-content"><span class="addto-label">Adicionar a</span></span></button><button type="button" class="end yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-menu-id="shared-addto-menu" data-button-action="" role="button" aria-pressed="false"> <img class="yt-uix-button-arrow" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""></button></span>
<span class="video-in-quicklist">Adicionado à fila     </span></a>
    
    <div class="video-details">
      <h3 class="chart-rank-title">
        <span class="rank">12</span>
        <a href="/watch?v=Hr0Wv5DJhuk" class="video-title" title="Miley Cyrus - 7 Things" dir="ltr">Miley Cyrus - 7 Things</a>
      </h3>
      <p class="description">
        Music video by Miley Cyrus performing 7 Things.
      </p>
      <ul class="facets">
        <li>  <span class="video-username">
por <a title="hollywoodrecords" href="/user/hollywoodrecords">hollywoodrecords</a>
  </span>
</li>
        <li>há 2 anos</li>
        <li class="last"><strong>139574088 visualizações
</strong></li>
      </ul>
    </div>
  </li>

      <li>
    
  




  


    

<a href="/watch?v=2Abk1jAONjw" class="ux-thumb-wrap contains-addto"><span class="video-thumb ux-thumb-128 "><span class="clip"><img src="http://i3.ytimg.com/vi/2Abk1jAONjw/default.jpg" class="" title="Lady Gaga - Just Dance ft. Colby O'Donis" ></span></span><span class="video-time">4:07</span>  





<span dir="ltr" class="yt-uix-button-group addto-container short video-actions" data-video-ids="2Abk1jAONjw" data-feature="thumbnail"><button type="button" class="master-sprite start yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-action="yt.www.addtomenu.add" role="button" aria-pressed="false"><img class="yt-uix-button-icon-addto" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""> <span class="yt-uix-button-content"><span class="addto-label">Adicionar a</span></span></button><button type="button" class="end yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-menu-id="shared-addto-menu" data-button-action="" role="button" aria-pressed="false"> <img class="yt-uix-button-arrow" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""></button></span>
<span class="video-in-quicklist">Adicionado à fila     </span></a>
    
    <div class="video-details">
      <h3 class="chart-rank-title">
        <span class="rank">13</span>
        <a href="/watch?v=2Abk1jAONjw" class="video-title" title="Lady Gaga - Just Dance ft. Colby O'Donis" dir="ltr">Lady Gaga - Just Dance ft. Colby O'Donis</a>
      </h3>
      <p class="description">
        Music video by Lady Gaga performing Just Dance....
      </p>
      <ul class="facets">
        <li>  <span class="video-username">
por <a title="LadyGagaVEVO" href="/user/LadyGagaVEVO">LadyGagaVEVO</a>
  </span>
</li>
        <li>há 1 ano</li>
        <li class="last"><strong>128503775 visualizações
</strong></li>
      </ul>
    </div>
  </li>

      <li>
    
  




  


    

<a href="/watch?v=1uwOL4rB-go" class="ux-thumb-wrap contains-addto"><span class="video-thumb ux-thumb-128 "><span class="clip"><img src="http://i2.ytimg.com/vi/1uwOL4rB-go/default.jpg" class="" title="Jeff Dunham - Achmed the Dead Terrorist" ></span></span><span class="video-time">10:48</span>  





<span dir="ltr" class="yt-uix-button-group addto-container short video-actions" data-video-ids="1uwOL4rB-go" data-feature="thumbnail"><button type="button" class="master-sprite start yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-action="yt.www.addtomenu.add" role="button" aria-pressed="false"><img class="yt-uix-button-icon-addto" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""> <span class="yt-uix-button-content"><span class="addto-label">Adicionar a</span></span></button><button type="button" class="end yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-menu-id="shared-addto-menu" data-button-action="" role="button" aria-pressed="false"> <img class="yt-uix-button-arrow" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""></button></span>
<span class="video-in-quicklist">Adicionado à fila     </span></a>
    
    <div class="video-details">
      <h3 class="chart-rank-title">
        <span class="rank">14</span>
        <a href="/watch?v=1uwOL4rB-go" class="video-title" title="Jeff Dunham - Achmed the Dead Terrorist" dir="ltr">Jeff Dunham - Achmed the Dead Terrorist</a>
      </h3>
      <p class="description">
        http://krowcomedy.blogspot.com/

 -------------...
      </p>
      <ul class="facets">
        <li>  <span class="video-username">
por <a title="KrowBatellio" href="/user/KrowBatellio">KrowBatellio</a>
  </span>
</li>
        <li>há 3 anos</li>
        <li class="last"><strong>125004186 visualizações
</strong></li>
      </ul>
    </div>
  </li>

      <li>
    
  




  


    

<a href="/watch?v=NG2zyeVRcbs" class="ux-thumb-wrap contains-addto"><span class="video-thumb ux-thumb-128 "><span class="clip"><img src="http://i3.ytimg.com/vi/NG2zyeVRcbs/default.jpg" class="" title="Miley Cyrus - The Climb - Official Music Video (HQ)" ></span></span><span class="video-time">3:49</span>  





<span dir="ltr" class="yt-uix-button-group addto-container short video-actions" data-video-ids="NG2zyeVRcbs" data-feature="thumbnail"><button type="button" class="master-sprite start yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-action="yt.www.addtomenu.add" role="button" aria-pressed="false"><img class="yt-uix-button-icon-addto" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""> <span class="yt-uix-button-content"><span class="addto-label">Adicionar a</span></span></button><button type="button" class="end yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-menu-id="shared-addto-menu" data-button-action="" role="button" aria-pressed="false"> <img class="yt-uix-button-arrow" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""></button></span>
<span class="video-in-quicklist">Adicionado à fila     </span></a>
    
    <div class="video-details">
      <h3 class="chart-rank-title">
        <span class="rank">15</span>
        <a href="/watch?v=NG2zyeVRcbs" class="video-title" title="Miley Cyrus - The Climb - Official Music Video (HQ)" dir="ltr">Miley Cyrus - The Climb - Official Music Video ...</a>
      </h3>
      <p class="description">
        The Climb is the brand new hit single from Mile...
      </p>
      <ul class="facets">
        <li>  <span class="video-username">
por <a title="hollywoodrecords" href="/user/hollywoodrecords">hollywoodrecords</a>
  </span>
</li>
        <li>há 1 ano</li>
        <li class="last"><strong>121433159 visualizações
</strong></li>
      </ul>
    </div>
  </li>

      <li>
    
  




  


    

<a href="/watch?v=_Z5-P9v3F8w" class="ux-thumb-wrap contains-addto"><span class="video-thumb ux-thumb-128 "><span class="clip"><img src="http://i4.ytimg.com/vi/_Z5-P9v3F8w/default.jpg" class="" title="Justin Bieber - Never Say Never ft. Jaden Smith" ></span></span><span class="video-time">3:50</span>  





<span dir="ltr" class="yt-uix-button-group addto-container short video-actions" data-video-ids="_Z5-P9v3F8w" data-feature="thumbnail"><button type="button" class="master-sprite start yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-action="yt.www.addtomenu.add" role="button" aria-pressed="false"><img class="yt-uix-button-icon-addto" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""> <span class="yt-uix-button-content"><span class="addto-label">Adicionar a</span></span></button><button type="button" class="end yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-menu-id="shared-addto-menu" data-button-action="" role="button" aria-pressed="false"> <img class="yt-uix-button-arrow" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""></button></span>
<span class="video-in-quicklist">Adicionado à fila     </span></a>
    
    <div class="video-details">
      <h3 class="chart-rank-title">
        <span class="rank">16</span>
        <a href="/watch?v=_Z5-P9v3F8w" class="video-title" title="Justin Bieber - Never Say Never ft. Jaden Smith" dir="ltr">Justin Bieber - Never Say Never ft. Jaden Smith</a>
      </h3>
      <p class="description">
        Music video by Justin Bieber performing Never S...
      </p>
      <ul class="facets">
        <li>  <span class="video-username">
por <a title="JustinBieberVEVO" href="/user/JustinBieberVEVO">JustinBieberVEVO</a>
  </span>
</li>
        <li>há 6 meses</li>
        <li class="last"><strong>121293337 visualizações
</strong></li>
      </ul>
    </div>
  </li>

      <li>
    
  




  


    

<a href="/watch?v=e82VE8UtW8A" class="ux-thumb-wrap contains-addto"><span class="video-thumb ux-thumb-128 "><span class="clip"><img src="http://i2.ytimg.com/vi/e82VE8UtW8A/default.jpg" class="" title="Rihanna - Rude Boy" ></span></span><span class="video-time">3:46</span>  





<span dir="ltr" class="yt-uix-button-group addto-container short video-actions" data-video-ids="e82VE8UtW8A" data-feature="thumbnail"><button type="button" class="master-sprite start yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-action="yt.www.addtomenu.add" role="button" aria-pressed="false"><img class="yt-uix-button-icon-addto" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""> <span class="yt-uix-button-content"><span class="addto-label">Adicionar a</span></span></button><button type="button" class="end yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-menu-id="shared-addto-menu" data-button-action="" role="button" aria-pressed="false"> <img class="yt-uix-button-arrow" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""></button></span>
<span class="video-in-quicklist">Adicionado à fila     </span></a>
    
    <div class="video-details">
      <h3 class="chart-rank-title">
        <span class="rank">17</span>
        <a href="/watch?v=e82VE8UtW8A" class="video-title" title="Rihanna - Rude Boy" dir="ltr">Rihanna - Rude Boy</a>
      </h3>
      <p class="description">
        Music video by Rihanna performing Rude Boy. (C)...
      </p>
      <ul class="facets">
        <li>  <span class="video-username">
por <a title="RihannaVEVO" href="/user/RihannaVEVO">RihannaVEVO</a>
  </span>
</li>
        <li>há 10 meses</li>
        <li class="last"><strong>120062789 visualizações
</strong></li>
      </ul>
    </div>
  </li>

      <li>
    
  




  


    

<a href="/watch?v=zBbMAJgBymA" class="ux-thumb-wrap contains-addto"><span class="video-thumb ux-thumb-128 "><span class="clip"><img src="http://i3.ytimg.com/vi/zBbMAJgBymA/default.jpg" class="" title="Tootin' Bathtub Baby Cousins" ></span></span><span class="video-time">0:36</span>  





<span dir="ltr" class="yt-uix-button-group addto-container short video-actions" data-video-ids="zBbMAJgBymA" data-feature="thumbnail"><button type="button" class="master-sprite start yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-action="yt.www.addtomenu.add" role="button" aria-pressed="false"><img class="yt-uix-button-icon-addto" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""> <span class="yt-uix-button-content"><span class="addto-label">Adicionar a</span></span></button><button type="button" class="end yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-menu-id="shared-addto-menu" data-button-action="" role="button" aria-pressed="false"> <img class="yt-uix-button-arrow" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""></button></span>
<span class="video-in-quicklist">Adicionado à fila     </span></a>
    
    <div class="video-details">
      <h3 class="chart-rank-title">
        <span class="rank">18</span>
        <a href="/watch?v=zBbMAJgBymA" class="video-title" title="Tootin' Bathtub Baby Cousins" dir="ltr">Tootin' Bathtub Baby Cousins</a>
      </h3>
      <p class="description">
        These tootin' bathtub baby cousins sing a smell...
      </p>
      <ul class="facets">
        <li>  <span class="video-username">
por <a title="Flowgo" href="/user/Flowgo">Flowgo</a>
  </span>
</li>
        <li>há 3 anos</li>
        <li class="last"><strong>119463781 visualizações
</strong></li>
      </ul>
    </div>
  </li>

      <li>
    
  




  


    

<a href="/watch?v=niqrrmev4mA" class="ux-thumb-wrap contains-addto"><span class="video-thumb ux-thumb-128 "><span class="clip"><img src="http://i3.ytimg.com/vi/niqrrmev4mA/default.jpg" class="" title="Lady Gaga - Alejandro" ></span></span><span class="video-time">8:44</span>  





<span dir="ltr" class="yt-uix-button-group addto-container short video-actions" data-video-ids="niqrrmev4mA" data-feature="thumbnail"><button type="button" class="master-sprite start yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-action="yt.www.addtomenu.add" role="button" aria-pressed="false"><img class="yt-uix-button-icon-addto" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""> <span class="yt-uix-button-content"><span class="addto-label">Adicionar a</span></span></button><button type="button" class="end yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-menu-id="shared-addto-menu" data-button-action="" role="button" aria-pressed="false"> <img class="yt-uix-button-arrow" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""></button></span>
<span class="video-in-quicklist">Adicionado à fila     </span></a>
    
    <div class="video-details">
      <h3 class="chart-rank-title">
        <span class="rank">19</span>
        <a href="/watch?v=niqrrmev4mA" class="video-title" title="Lady Gaga - Alejandro" dir="ltr">Lady Gaga - Alejandro</a>
      </h3>
      <p class="description">
        Music video by Lady Gaga performing Alejandro. ...
      </p>
      <ul class="facets">
        <li>  <span class="video-username">
por <a title="LadyGagaVEVO" href="/user/LadyGagaVEVO">LadyGagaVEVO</a>
  </span>
</li>
        <li>há 6 meses</li>
        <li class="last"><strong>109978676 visualizações
</strong></li>
      </ul>
    </div>
  </li>

      <li>
    
  




  


    

<a href="/watch?v=embdtwW-sSE" class="ux-thumb-wrap contains-addto"><span class="video-thumb ux-thumb-128 "><span class="clip"><img src="http://i2.ytimg.com/vi/embdtwW-sSE/default.jpg" class="" title="Best Ever!!!" ></span></span><span class="video-time">4:35</span>  





<span dir="ltr" class="yt-uix-button-group addto-container short video-actions" data-video-ids="embdtwW-sSE" data-feature="thumbnail"><button type="button" class="master-sprite start yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-action="yt.www.addtomenu.add" role="button" aria-pressed="false"><img class="yt-uix-button-icon-addto" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""> <span class="yt-uix-button-content"><span class="addto-label">Adicionar a</span></span></button><button type="button" class="end yt-uix-button yt-uix-button-short yt-uix-tooltip" onclick=";return false;" title="" data-button-menu-id="shared-addto-menu" data-button-action="" role="button" aria-pressed="false"> <img class="yt-uix-button-arrow" src="http://s.ytimg.com/yt/img/pixel-vfl3z5WfW.gif" alt=""></button></span>
<span class="video-in-quicklist">Adicionado à fila     </span></a>
    
    <div class="video-details">
      <h3 class="chart-rank-title">
        <span class="rank">20</span>
        <a href="/watch?v=embdtwW-sSE" class="video-title" title="Best Ever!!!" dir="ltr">Best Ever!!!</a>
      </h3>
      <p class="description">
        Like this video?  You'll LOVE this:  http://www...
      </p>
      <ul class="facets">
        <li>  <span class="video-username">
por <a title="kicesie" href="/user/kicesie">kicesie</a>
  </span>
</li>
        <li>há 3 anos</li>
        <li class="last"><strong>108822217 visualizações
</strong></li>
      </ul>
    </div>
  </li>

  </ol>

    
    
  
    <div class="yt-uix-pager">


      <button href="/charts/videos_views?t=a&amp;p=1" type="button" class="yt-uix-pager-selected yt-uix-button" onclick="return false;;window.location.href=this.getAttribute('href');return false;" data-page="1" role="button" aria-pressed="false"><span class="yt-uix-button-content">1</span></button>&nbsp;
      <button href="/charts/videos_views?t=a&amp;p=2" type="button" class=" yt-uix-button" onclick=";window.location.href=this.getAttribute('href');return false;" data-page="2" role="button" aria-pressed="false"><span class="yt-uix-button-content">2</span></button>&nbsp;
      <button href="/charts/videos_views?t=a&amp;p=3" type="button" class=" yt-uix-button" onclick=";window.location.href=this.getAttribute('href');return false;" data-page="3" role="button" aria-pressed="false"><span class="yt-uix-button-content">3</span></button>&nbsp;
      <button href="/charts/videos_views?t=a&amp;p=4" type="button" class=" yt-uix-button" onclick=";window.location.href=this.getAttribute('href');return false;" data-page="4" role="button" aria-pressed="false"><span class="yt-uix-button-content">4</span></button>&nbsp;
      <button href="/charts/videos_views?t=a&amp;p=5" type="button" class=" yt-uix-button" onclick=";window.location.href=this.getAttribute('href');return false;" data-page="5" role="button" aria-pressed="false"><span class="yt-uix-button-content">5</span></button>&nbsp;
      <button href="/charts/videos_views?t=a&amp;p=6" type="button" class=" yt-uix-button" onclick=";window.location.href=this.getAttribute('href');return false;" data-page="6" role="button" aria-pressed="false"><span class="yt-uix-button-content">6</span></button>&nbsp;
      <button href="/charts/videos_views?t=a&amp;p=7" type="button" class=" yt-uix-button" onclick=";window.location.href=this.getAttribute('href');return false;" data-page="7" role="button" aria-pressed="false"><span class="yt-uix-button-content">7</span></button>&nbsp;
      <button href="/charts/videos_views?t=a&amp;p=8" type="button" class=" yt-uix-button" onclick=";window.location.href=this.getAttribute('href');return false;" data-page="8" role="button" aria-pressed="false"><span class="yt-uix-button-content">8</span></button>&nbsp;

          <a href="/charts/videos_views?t=a&p=2" class="yt-uix-pager-link" data-page="2" >Seguinte</a>

    </div>

  </div>

  </div>
  <!-- end content -->
  <!-- begin pagebottom -->
  <div id="pagebottom">
    <div id="footer-container">
        <div id="footer">
    <ul class="footer-links">
      <li><a href="http://www.google.com/support/youtube/bin/static.py?p=&amp;page=start.cs&amp;hl=pt_PT" onmousedown="yt.analytics.trackEvent('Footer', 'link', 'Help');">Ajuda</a>
</li>
      <li><a href="/press_room" onmousedown="yt.analytics.trackEvent('Footer', 'link', 'Press');">Sala de imprensa</a></li>
      <li><a href="/t/about">Acerca de</a></li>
      <li><a href="http://www.google.com/support/youtube/bin/request.py?contact_type=abuse&amp;hl=pt_PT">Segurança</a></li>
      <li><a href="/t/privacy_at_youtube">Privacidade</a></li>
      <li><a href="/t/terms">Termos</a></li>
      <li><a href="/t/dmca_policy">Direitos de autor</a></li>
      <li><a href="/t/uploaders_partners">Remetentes e parceiros</a></li>
        <li><a href="http://code.google.com/intl/pt-PT/apis/youtube/overview.html">Programadores</a></li>
      <li><a href="/t/advertising_overview" onmousedown="yt.analytics.trackEvent('Footer', 'link', 'Advertising');">Publicidade</a></li>
    </ul>

    <p class="footer-info">
      <a href="http://www.google.com/tools/feedback/intl/pt/error.html" onclick="return yt.www.feedback.start('pt',{accept_language: 'pt-PT,pt;q=0.8,en-US;q=0.6,en;q=0.4'});" id="reportbug">Comunicar um erro</a>
    </p>
      <ul class="pickers">
      <li>Idioma:
  <a href="#" onclick="yt.www.masthead.loadPicker('language-picker', ''); return false;">Português</a>
</li>
      <li>Localização:
  <a href="#" onclick="yt.www.masthead.loadPicker('region-picker', ''); return false;">Mundial</a>
</li>
      <li>Modo de segurança:
  <a href="#" onclick="yt.www.masthead.loadPicker('safetymode-picker', ''); return false;">

Desactivado

  </a>
</li>
  </ul>
    <div id="picker-container"></div>
  <div id="picker-loading" style="display: none">A carregar...</div>


  </div>

    </div>
        '''

l = re.findall("href=\"(/watch?.+?)\"", text, re.DOTALL)

for el in l:
	print '"www.youtube.com%s",' % el

	'''
// java - add to db
UserManager  manager = UserManager.getInstance();
        
String[] videoUrls = {"www.youtube.com/watch?v=kffacxfA7G4","www.youtube.com/watch?v=qrO4YZeyl0I","www.youtube.com/watch?v=qrO4YZeyl0I","www.youtube.com/watch?v=_OBlgSz8sSM","www.youtube.com/watch?v=_OBlgSz8sSM","www.youtube.com/watch?v=pRpeEdMmmQ0","www.youtube.com/watch?v=pRpeEdMmmQ0","www.youtube.com/watch?v=uelHwf8o7_U","www.youtube.com/watch?v=uelHwf8o7_U","www.youtube.com/watch?v=M11SvDtPBhA","www.youtube.com/watch?v=M11SvDtPBhA","www.youtube.com/watch?v=j5-yKhDd64s","www.youtube.com/watch?v=j5-yKhDd64s","www.youtube.com/watch?v=dMH0bHeiRNg","www.youtube.com/watch?v=dMH0bHeiRNg","www.youtube.com/watch?v=E2tMV96xULk","www.youtube.com/watch?v=E2tMV96xULk","www.youtube.com/watch?v=5P6UU6m3cqk","www.youtube.com/watch?v=5P6UU6m3cqk","www.youtube.com/watch?v=6Jlv8F9cerA","www.youtube.com/watch?v=6Jlv8F9cerA","www.youtube.com/watch?v=Hr0Wv5DJhuk","www.youtube.com/watch?v=Hr0Wv5DJhuk","www.youtube.com/watch?v=2Abk1jAONjw","www.youtube.com/watch?v=2Abk1jAONjw","www.youtube.com/watch?v=1uwOL4rB-go","www.youtube.com/watch?v=1uwOL4rB-go","www.youtube.com/watch?v=NG2zyeVRcbs","www.youtube.com/watch?v=NG2zyeVRcbs","www.youtube.com/watch?v=_Z5-P9v3F8w","www.youtube.com/watch?v=_Z5-P9v3F8w","www.youtube.com/watch?v=e82VE8UtW8A","www.youtube.com/watch?v=e82VE8UtW8A","www.youtube.com/watch?v=zBbMAJgBymA","www.youtube.com/watch?v=zBbMAJgBymA","www.youtube.com/watch?v=niqrrmev4mA","www.youtube.com/watch?v=niqrrmev4mA","www.youtube.com/watch?v=embdtwW-sSE","www.youtube.com/watch?v=embdtwW-sSE"};

Random r = new Random(System.currentTimeMillis());

for (String url : videoUrls) {
	Video v = new Video(-1);
	v.setUrl(url);
	v.setCreatedBy(manager.getUser(3002 + r.nextInt(814)));
	ItemManager.getInstance().persistItem(v);

}
'''