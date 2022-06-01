class Point:
  # 클래스속성(정적 변수)
  name = 'Point'
  
  # 메소드를 정의할 때 첫번째 인자로 self(this) 를 넘겨줘야함. self는 호출시 생략된다
  
  # 생성자
  # 인스턴스 속성(멤버변수) 선언은 생성자 및 메소드에서
  def __init__(self, x, y):
    self.x = x
    self.y = y
    
  # 출력 방식 지정 @toString()
  def __str__(self):
    return '({} {})'.format(self.x, self.y)
    
point = Point(1,2)

print(point, point.name)