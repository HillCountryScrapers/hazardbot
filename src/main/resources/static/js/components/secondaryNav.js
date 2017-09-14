+function ($) {
  'use strict';

  $(function () {
    $('.more').each(function() {
      $(this).on('scroll', function () {
        var cur = Math.floor($(this).scrollLeft());
        if (cur === 0) {
          $(this).addClass('shadow-right').removeClass('shadow-left');
        } else {
          var max = Math.floor($(this)[0].scrollWidth) - Math.floor($(this).parent().width()) - 1;
          if (cur === max) {
            $(this).addClass('shadow-left').removeClass('shadow-right');
          } else {
            $(this).addClass('shadow-right shadow-left');
          }
        }
      });
      if ($(this).length > 0 && $(this).isHorizontallyScrollable()) {
        $(this).trigger('scroll');
      }
    });
  });

  $(window).on('resize', function () {
    $('.more').each(function() {
      if ($(this).length > 0 && !$(this).isHorizontallyScrollable()) {
        $(this).removeClass('shadow-right shadow-left');
      }
    });
  });


  /**
   * Detects whether element can be scrolled horizontally.
   * @this jQuery
   * @return {boolean}
   */
  $.fn.isHorizontallyScrollable = function () {

    if (this.scrollLeft()) {
      // Element is already scrolled, so it is scrollable
      return true;
    } else {
      // Test by actually scrolling
      this.scrollLeft(1);

      if (this.scrollLeft()) {
        // Scroll back
        this.scrollLeft(0);
        return true;
      }
    }
    return false;
  };

  $.extend($.expr.pseudos || $.expr[":"], {
    "horizontally-scrollable": function (a) {
      return $(a).isHorizontallyScrollable();
    }
  });
}(jQuery);